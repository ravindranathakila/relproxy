
package example.groovyex;

import org.itsnat.core.http.ItsNatHttpServlet;
import org.itsnat.core.tmpl.ItsNatDocumentTemplate;
import org.itsnat.core.event.ItsNatServletRequestListener;
import java.lang.reflect.Method;
import com.innowhere.relproxy.RelProxyOnReloadListener;
import com.innowhere.relproxy.gproxy.GProxy;
import com.innowhere.relproxy.gproxy.GProxyGroovyScriptEngine;
import com.innowhere.relproxy.gproxy.GProxyConfig;

def groovyEngine = {
             String scriptName -> return (java.lang.Class)servlet.getGroovyScriptEngine().loadScriptByName(scriptName) 
        } as GProxyGroovyScriptEngine;

/* This alternative throws a weird error when called loadScriptByName, why?
GProxyGroovyScriptEngine groovyEngine = 
        {
            loadScriptByName : { String scriptName -> return (java.lang.Class)servlet.getGroovyScriptEngine().loadScriptByName(scriptName)  }            
        } as GProxyGroovyScriptEngine;
*/

def reloadListener = { 
        Object objOld,Object objNew,Object proxy, Method method, Object[] args -> 
           println("Reloaded " + objNew + " Calling method: " + method)
      } as RelProxyOnReloadListener;

def gpConfig = GProxy.createGProxyConfig();
gpConfig.setEnabled(true).setRelProxyOnReloadListener(reloadListener).setGProxyGroovyScriptEngine(groovyEngine);

GProxy.init(gpConfig);


def db = new FalseDB();

String pathPrefix = context.getRealPath("/") + "/WEB-INF/groovyex/pages/";

def docTemplate;
docTemplate = itsNatServlet.registerItsNatDocumentTemplate("groovyex","text/html", pathPrefix + "groovyex.html");

ItsNatServletRequestListener listener = GProxy.create(new example.groovyex.GroovyExampleLoadListener(db), ItsNatServletRequestListener.class);
docTemplate.addItsNatServletRequestListener(listener);


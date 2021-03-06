package com.innowhere.relproxy.impl.jproxy.clsmgr;

import java.io.File;

/**
 *
 * @author jmarranz
 */
public class ClassDescriptorSourceFileJava extends ClassDescriptorSourceUnit
{
    public ClassDescriptorSourceFileJava(JProxyEngine engine,String className, SourceFileJavaNormal sourceFile, long timestamp)
    {
        super(engine,className, sourceFile, timestamp);
    }
    
    public SourceFileJavaNormal getSourceFileJavaNormal()
    {
        return (SourceFileJavaNormal)sourceFile;
    }
    
    public File getSourceFile()
    {
        return getSourceFileJavaNormal().getFile();
    }    
     
}

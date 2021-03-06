package com.innowhere.relproxy.impl.jproxy.clsmgr;

import java.io.File;

/**
 *
 * @author jmarranz
 */
public abstract class SourceScript extends SourceUnit
{
    public abstract String getScriptCode(String encoding);
    public abstract String getClassNameFromSourceFileScriptAbsPath(File rootPathOfSourcesFile);    
}

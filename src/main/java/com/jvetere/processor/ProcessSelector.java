package com.jvetere.processor;

public class ProcessSelector {
    public static Processor chooseProcess(String _fileName, ProcessType _type) {
        String              fileName;
        ProcessType         type;
        fileName            = _fileName;
        type                = _type;

        switch (type){
            case DOMINATE_COLOR, COLOR_MIX_UP -> {
                return new InImageColorProcessor(fileName, type);
            }
            case COMPONENT_MAP, MERGED_COMPONENT -> {
                return new ComponentProcessor(fileName, type);
            }
        }
        return null;
    }
}

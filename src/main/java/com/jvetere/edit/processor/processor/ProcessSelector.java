package com.jvetere.edit.processor.processor;

import com.jvetere.edit.processor.processor.types.ProcessType;
import com.jvetere.edit.processor.processor.types.Processor;
import com.jvetere.edit.processor.processor.types.ComponentProcessor;
import com.jvetere.edit.processor.processor.types.InImageColorProcessor;

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

package com.ui.pojo;

import java.util.Map;

public class config {
    public Map<String, Environament> getEnvironments() {
        return environments;
    }

    public void setEnvironments(Map<String, Environament> environments) {
        this.environments = environments;
    }

    Map<String, Environament> environments;
}
//
//as json data is in key value format like url:value so we need to create the Map to access those value
//via POJO of URL
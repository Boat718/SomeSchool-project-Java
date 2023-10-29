package com.project.someschool.audit;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SomeSchoolInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("App Name", "SomeSchool");
        map.put("App Description", "Some School Web Application for Students and Admin");
        map.put("App Version", "1.0.0");
        map.put("Contact Email", "info@Someschool.com");
        map.put("Contact Mobile", "+1(21) 673 4587");
        builder.withDetail("Someschool-info", map);
    }

}

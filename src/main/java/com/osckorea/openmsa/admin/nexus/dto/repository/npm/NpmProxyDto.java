package com.osckorea.openmsa.admin.nexus.dto.repository.npm;

import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Cleanup;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.HttpClient;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.NegativeCache;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Proxy;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Storage;

import lombok.Getter;

@Getter
public class NpmProxyDto {
    private String name;
    private String url;
    private String format;
    private String type;
    private Boolean online;

    private Storage storage;
    private Cleanup cleanup;
    private Proxy proxy;
    private NegativeCache negativeCache;
    private HttpClient httpClient;
    private String routingRuleName;

    private Npm npm;
}

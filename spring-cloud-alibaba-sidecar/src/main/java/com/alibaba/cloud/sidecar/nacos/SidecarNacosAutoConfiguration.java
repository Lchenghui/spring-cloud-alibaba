/*
 * Copyright (C) 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.cloud.sidecar.nacos;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClientAutoConfiguration;
import com.alibaba.cloud.sidecar.SidecarAutoConfiguration;
import com.alibaba.cloud.sidecar.SidecarDiscoveryClient;
import com.alibaba.cloud.sidecar.SidecarProperties;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author www.itmuch.com
 */
@Configuration
@AutoConfigureBefore({NacosDiscoveryClientAutoConfiguration.class, SidecarAutoConfiguration.class})
@ConditionalOnClass(NacosDiscoveryProperties.class)
public class SidecarNacosAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public SidecarNacosDiscoveryProperties sidecarNacosDiscoveryProperties(SidecarProperties sidecarProperties) {
        return new SidecarNacosDiscoveryProperties(sidecarProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public SidecarDiscoveryClient sidecarDiscoveryClient(SidecarNacosDiscoveryProperties sidecarNacosDiscoveryProperties) {
        return new SidecarNacosDiscoveryClient(sidecarNacosDiscoveryProperties);
    }
}

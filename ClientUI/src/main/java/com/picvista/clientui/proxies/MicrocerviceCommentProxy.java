package com.picvista.clientui.proxies;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "microservice-comments",url = "localhost:5013")
public interface MicrocerviceCommentProxy {


}

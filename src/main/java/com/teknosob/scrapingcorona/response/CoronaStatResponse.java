package com.teknosob.scrapingcorona.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoronaStatResponse {
    private String confirmed;
    private String recovered;
    private String deaths;
}

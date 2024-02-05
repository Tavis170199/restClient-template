package com.gabs.schedule.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabs.schedule.dto.Breed;
import com.gabs.schedule.dto.Links;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BreedModel {

    private List<Breed> data;

    @JsonProperty("current_page")
    private int currentPage;

    @JsonProperty("first_page_url")
    private String first_page_url;

    private String from;

    @JsonProperty("last_page")
    private int lastPage;

    @JsonProperty("last_page_url")
    private String last_page_url;
    private List<Links> links;

    @JsonProperty("next_page_url")
    private String next_page_url;
    private String path;

    @JsonProperty("per_page")
    private String per_page;

    @JsonProperty("prev_page_url")
    private String prev_page_url;
    private int to;
    private int total;

}

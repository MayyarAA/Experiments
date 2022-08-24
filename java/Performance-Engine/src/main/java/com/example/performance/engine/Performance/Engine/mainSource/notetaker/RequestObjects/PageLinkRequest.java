package com.example.performance.engine.Performance.Engine.mainSource.notetaker.RequestObjects;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page.Page;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageLinkRequest {
    private String noteBookId;
    //    private String noteId;
    private Page page;
}

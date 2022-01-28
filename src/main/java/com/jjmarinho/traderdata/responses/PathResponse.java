package com.jjmarinho.traderdata.responses;

import java.nio.file.Path;

public class PathResponse {
    public String filepath;

    public PathResponse(Path filepath) {
        this.filepath = filepath.toString();
    }
}

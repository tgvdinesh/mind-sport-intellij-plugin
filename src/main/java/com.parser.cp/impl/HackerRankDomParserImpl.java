package com.parser.cp.impl;

import com.parser.cp.DomParser;
import com.parser.cp.exception.ImpartialException;
import com.parser.cp.model.Task;
import com.parser.cp.util.Common;
import org.jsoup.nodes.Document;

import java.util.LinkedList;
import java.util.List;

public class HackerRankDomParserImpl implements DomParser {
    private static final List<String> INPUT_SELECTORS = new LinkedList<>();
    private static final List<String> OUTPUT_SELECTORS = new LinkedList<>();

    static {
        INPUT_SELECTORS.add("#content div.challenge_sample_input_body");
        OUTPUT_SELECTORS.add("#content div.challenge_sample_output_body");
    }

    private Document document;

    public HackerRankDomParserImpl() {

    }

    public HackerRankDomParserImpl(Document document) {
        this.document = document;
    }

    @Override
    public Task parse(String domAsString) throws ImpartialException {
        return Common.getTask(domAsString, INPUT_SELECTORS, OUTPUT_SELECTORS);
    }

    public Document getDocument() {
        return document;
    }
}

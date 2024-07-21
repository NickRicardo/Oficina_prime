package com.oficinaPrime.backend.model;

import com.oficinaPrime.backend.domain.enums.State;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CityDataLoader {

    private static final String API_URL_TEMPLATE = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/%s/distritos";

    public static Map<State, List<String>> loadCitiesFromAPI() throws Exception {
        Map<State, List<String>> stateCitiesMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        for (State state : State.values()) {
            String url = String.format(API_URL_TEMPLATE, state.getUf());
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                JsonNode rootNode = objectMapper.readTree(reader);
                List<String> cities = rootNode.findValues("nome").stream()
                        .map(JsonNode::asText)
                        .collect(Collectors.toList());
                stateCitiesMap.put(state, cities);
            }
        }

        return stateCitiesMap;
    }
}

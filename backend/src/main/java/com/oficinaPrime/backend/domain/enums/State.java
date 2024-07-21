package com.oficinaPrime.backend.domain.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oficinaPrime.backend.model.CityDataLoader;

public enum State {
    AC("AC"), AL("AL"), AP("AP"), AM("AM"), BA("BA"), CE("CE"), DF("DF"), ES("ES"), GO("GO"), MA("MA"), MT("MT"), MS("MS"), MG("MG"), PA("PA"), PB("PB"), PR("PR"), PE("PE"), PI("PI"), RJ("RJ"), RN("RN"), RS("RS"), RO("RO"), RR("RR"), SC("SC"), SP("SP"), SE("SE"), TO("TO");

    private final String uf;
    private List<String> cities;

    State(String uf) {
        this.uf = uf;
        this.cities = new ArrayList<>();
    }

    public String getUf() {
        return uf;
    }

    public List<String> getCities() {
        return cities;
    }

    private static final Map<State, List<String>> stateCitiesMap = new HashMap<>();

    static {
        try {
            stateCitiesMap.putAll(CityDataLoader.loadCitiesFromAPI());
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (State state : State.values()) {
            state.cities = stateCitiesMap.getOrDefault(state, new ArrayList<>());
        }
    }
}

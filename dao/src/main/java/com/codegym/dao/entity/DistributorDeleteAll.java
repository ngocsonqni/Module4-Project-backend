package com.codegym.dao.entity;

import java.util.List;

public class DistributorDeleteAll {
    List<Distributor> successList;
    List<Distributor> outSessionList;
    List<Distributor> unsuccessList;

    public List<Distributor> getSuccessList() {
        return successList;
    }

    public void setSuccessList(List<Distributor> successList) {
        this.successList = successList;
    }

    public List<Distributor> getOutSessionList() {
        return outSessionList;
    }

    public void setOutSessionList(List<Distributor> outSessionList) {
        this.outSessionList = outSessionList;
    }

    public List<Distributor> getUnsuccessList() {
        return unsuccessList;
    }

    public void setUnsuccessList(List<Distributor> unsuccessList) {
        this.unsuccessList = unsuccessList;
    }

    public DistributorDeleteAll(List<Distributor> successList, List<Distributor> outSessionList, List<Distributor> unsuccessList) {
        this.successList = successList;
        this.outSessionList = outSessionList;
        this.unsuccessList = unsuccessList;
    }
}

package com.codegym.dao.entity;

import java.util.List;

public class DistributorDeleteAll {
    List<Distributor> successList;
    List<Distributor> modifyingList;
    List<Distributor> unsuccessList;

    public List<Distributor> getSuccessList() {
        return successList;
    }

    public void setSuccessList(List<Distributor> successList) {
        this.successList = successList;
    }

    public List<Distributor> getModifyingList() {
        return modifyingList;
    }

    public void setModifyingList(List<Distributor> modifyingList) {
        this.modifyingList = modifyingList;
    }

    public DistributorDeleteAll() {
    }

    public DistributorDeleteAll(List<Distributor> successList, List<Distributor> modifyingList, List<Distributor> unsuccessList) {
        this.successList = successList;
        this.modifyingList = modifyingList;
        this.unsuccessList = unsuccessList;
    }

    public List<Distributor> getUnsuccessList() {
        return unsuccessList;
    }

    public void setUnsuccessList(List<Distributor> unsuccessList) {
        this.unsuccessList = unsuccessList;
    }
}

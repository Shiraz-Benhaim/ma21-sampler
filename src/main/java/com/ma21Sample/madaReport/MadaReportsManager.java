package com.ma21Sample.madaReport;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class MadaReportsManager {
    private List<MadaReport> reports;

    public MadaReportsManager() {
        this.reports = new ArrayList<>();
    }

    public int numOfReports() {
        return this.reports.size();
    }

    public void addMadaReport(MadaReport madaReport) {
        this.reports.add(madaReport);
    }
}


package edu.miu.cs425.project.crs.model.report;

import edu.miu.cs425.project.crs.model.Block;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PieChart {

    private List<String> labels = new ArrayList<>();
    private List<Dataset> datasets = new ArrayList<>();

    @Data
    class Dataset{
        private List<Integer> data = new ArrayList<>();
        private List<String> backgroundColor = new ArrayList<>();

        public Dataset(List<Integer> data, List<String> backgroundColor) {
            this.data = data;
            this.backgroundColor = backgroundColor;
        }
    }

    public PieChart(Block block) {
        List<String> colors = Arrays.asList("#007bff", "#dc3545", "#ffc107", "#28a123", "#42f5e9", "#c542f5", "#b0f542", "#f5b942", "#f54296");
        List<String> classes = block.getClasses().stream().map(c->c.getCourse().getId()).collect(Collectors.toList());
        List<Integer> availableSeats = block.getClasses().stream().map(c->c.getAvailableSeats()).collect(Collectors.toList());

        labels.addAll(classes);
        datasets.add(new Dataset(availableSeats, colors));

    }
}

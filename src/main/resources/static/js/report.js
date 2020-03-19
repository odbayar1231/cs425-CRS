// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Pie Chart - May
var aprilPieChart = document.getElementById("aprilPieChart");
var mayPieChart = document.getElementById("mayPieChart");
var junePieChart = document.getElementById("junePieChart");
var julyPieChart = document.getElementById("julyPieChart");
setPieChart(1, aprilPieChart);
setPieChart(2, mayPieChart);
setPieChart(3, junePieChart);
setPieChart(4, julyPieChart);


function setPieChart(blockId, pieChart){
  $.ajax({
    url: `/report/${blockId}`,
    type: 'GET',
    dataType: 'json', // added data type
    success: function(res) {
      var myPieChart = new Chart(pieChart, {
        type: 'pie',
        data: res
      });
    }
  });
}



<!--
  THIS EXAMPLE WAS DOWNLOADED FROM https://echarts.apache.org/examples/zh/editor.html?c=bar-label-rotation&theme=dark
-->
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN" style="height: 100%">
<head></head>
<body style="height: 100%; margin: 0">
  <div id="container" style="height: 100%"></div>

  <script type="text/javascript" src="https://fastly.jsdelivr.net/npm/echarts@5.3.2/dist/echarts.min.js"></script>
  <script src="/js/jquery-3.5.1.min.js"></script>
  <script type="text/javascript">
    var dom = document.getElementById('container');
    var myChart = echarts.init(dom, 'dark', {
      renderer: 'canvas',
      useDirtyRect: false
    });
    var app = {};

    var option;

    const posList = [
  'left',
  'right',
  'top',
  'bottom',
  'inside',
  'insideTop',
  'insideLeft',
  'insideRight',
  'insideBottom',
  'insideTopLeft',
  'insideTopRight',
  'insideBottomLeft',
  'insideBottomRight'
];
app.configParameters = {
  rotate: {
    min: -90,
    max: 90
  },
  align: {
    options: {
      left: 'left',
      center: 'center',
      right: 'right'
    }
  },
  verticalAlign: {
    options: {
      top: 'top',
      middle: 'middle',
      bottom: 'bottom'
    }
  },
  position: {
    options: posList.reduce(function (map, pos) {
      map[pos] = pos;
      return map;
    }, {})
  },
  distance: {
    min: 0,
    max: 100
  }
};
app.config = {
  rotate: 90,
  align: 'left',
  verticalAlign: 'middle',
  position: 'insideBottom',
  distance: 15,
  onChange: function () {
    const labelOption = {
      rotate: app.config.rotate,
      align: app.config.align,
      verticalAlign: app.config.verticalAlign,
      position: app.config.position,
      distance: app.config.distance
    };
    myChart.setOption({
      series: [
        {
          label: labelOption
        },
        {
          label: labelOption
        },
        {
          label: labelOption
        },
        {
          label: labelOption
        }
      ]
    });
  }
};
const labelOption = {
  show: true,
  position: app.config.position,
  distance: app.config.distance,
  align: app.config.align,
  verticalAlign: app.config.verticalAlign,
  rotate: app.config.rotate,
  formatter: '{c}  {name|{a}}',
  fontSize: 16,
  rich: {
    name: {}
  }
};




option = {
  title: {
    left: 10,
    top: 20,
    itemGap:30,
    text: '农作物价格详细信息展示',
    subtarget: 'self',
    subtext: '蔬菜需求详细信息展示',
    sublink: 'http://localhost:8082/admin/vegetablePage',
  },
  tooltip: {
    trigger: 'axis',
    axisPointer: {
      type: 'shadow'
    }
  },
  legend: {
    data: ['maxPrice', 'avgPrice','minPrice']
  },
  toolbox: {
    show: true,
    orient: 'vertical',
    left: 'right',
    top: 'center',
    feature: {
      mark: { show: true },
      dataView: { show: true, readOnly: false },
      magicType: { show: true, type: ['line', 'bar', 'stack'] },
      // restore: { show: true },
      saveAsImage: { show: true }
    }
  },
  xAxis: [
    {
      type: 'category',
      axisTick: { show: false },
      data: []
    }
  ],
  yAxis: [
    {
      type: 'value'
    }
  ],
  series: [
    {
      name: 'minPrice',
      type: 'bar',
      barGap: 0,
      label: labelOption,
      emphasis: {
        focus: 'series'
      },
      data: []
    },
    {
      name: 'avgPrice',
      type: 'bar',
      label: labelOption,
      emphasis: {
        focus: 'series'
      },
      data: []
    },
    {
      name: 'maxPrice',
      type: 'bar',
      label: labelOption,
      emphasis: {
        focus: 'series'
      },
      data: []
    },
  ]
};


    // 定义x、y轴数据数组
    var names=[];
    var minPrices=[];
    var maxPrices=[];
    var avgPrices=[];
    //请求后台数据
    $.ajax({
      type: "get",
      url: "/cropCleanPrice/list",
      contentType: "application/json",
      success: function(res){
        console.log("=====res: =======")
        console.log(res);
        for (var i = 0; i < res.length ; i++) {
          names.push(res[i].name);
          minPrices.push(res[i].minPrice);
          maxPrices.push(res[i].maxPrice);
          avgPrices.push(res[i].avgPrice);
        }
        myChart.setOption({
          xAxis: [{
            data: names
          }],
          series: [{
            // 根据名字对应到相应的系列
            //["#1089E7", "#f57474", "#56D0E3", "#F8B448", "#8B78F6"
            color: "#8B78F6",
            name: 'minPrice',
            data: minPrices
          },
          {
            color: "#56D0E3",
            name: 'avgPrice',
            data: avgPrices
          },
          {
            color: "#f57474",
            name: 'maxPrice',
            data: maxPrices
          }]
        });
      }
    });
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    if (option && typeof option === 'object') {
      myChart.setOption(option);
    }

    window.addEventListener('resize', myChart.resize);
  </script>
</body>
</html>
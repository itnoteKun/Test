// 1柱状图模块
(function() {
  // 实例化对象
  var myChart = echarts.init(document.querySelector(".bar .chart"));
  // 指定配置和数据
  var option = {
    //第二列柱状图  ，
    color: ["#4c9bfd"],
    tooltip: {
      trigger: "axis",
      axisPointer: {
        // 坐标轴指示器，坐标轴触发有效
        type: "shadow" // 默认为直线，可选为：'line' | 'shadow'
      }
    },
    grid: {
      left: "0%",
      top: "10px",
      right: "0%",
      bottom: "4%",
      containLabel: true
    },
    toolbox: {
      feature: {
        // saveAsImage: {}, // 导出图片
        // dataView: {}, // 数据视图
        // restore: {}, // 重置
        // dataZoom: {}, // 区域缩放
        magicType: {
          type: ['bar', 'line']
        } // 动态图表类型的切换
      }
    },
    legend: { // 图例, 图例中的data数据来源于series中每个对象的name, 图例可以帮助我们对图表进行筛选
      // padding: [0,10,40,0],
      left: 20,
      data: ['minPrice','maxPrice'],
      textStyle: {
        color: '#ffffff'
      }
    },
    xAxis: [
      {
        type: "category",
        data: [],
        axisTick: {
          alignWithLabel: true
        },
        axisLabel: {
          interval:0,
          textStyle: {
            color: "rgb(255,255,255)",
            fontSize: "12"
          }
        },
        axisLine: {
          show: false
        }
      }
    ],
    yAxis: [
      {
        type: "value",
        axisLabel: {
          textStyle: {
            color: "rgba(255,255,255)",
            fontSize: "12"
          }
        },
        axisLine: {
          lineStyle: {
            color: "rgba(255,255,255,.1)"
            // width: 1,
            // type: "solid"
          }
        },
        splitLine: {
          lineStyle: {
            color: "rgba(255,255,255,.1)"
          }
        }
      }
    ],
    //鼠标划过数据颜色
    series: [
      {
        name: "直接访问",
        type: "bar",
        color: "#ffffff",
        barWidth: "35%",
        data: [],
        itemStyle: {
          barBorderRadius: 5
        }
      },{
        name: "直接访问",
        type: "bar",
        barWidth: "35%",
        data: [],
        itemStyle: {
          barBorderRadius: 5
        }
      }
    ]
  };

  // 定义x、y轴数据数组
  var names=[];
  var minPrices=[];
  var maxPrices=[];
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
      }
      myChart.setOption({
        xAxis: [{
          type: "category",
          data: names
        }],
        series: [{
          // 根据名字对应到相应的系列
          color:"#00f2f1",
          name: 'minPrice',
          data: minPrices
        },{
          // 根据名字对应到相应的系列
          name: 'maxPrice',
          data: maxPrices
        }]
      });
    }
  });
  // 使用刚指定的配置项和数据显示图表。
  myChart.setOption(option);
  window.addEventListener("resize", function() {
    myChart.resize();
  });

})();

// 2折线图定制
(function() {
  // 基于准备好的dom，初始化echarts实例
  var myChart = echarts.init(document.querySelector(".line .chart"));

  // (1)准备数据
  var data = {
    year: [
      [24, 40, 101, 134, 90, 230, 210, 230, 120, 230, 210, 120],
      [40, 64, 191, 324, 290, 330, 310, 213, 180, 200, 180, 79]
    ]
  };

  // 2. 指定配置和数据
  var option = {
    color: ["#00f2f1", "#ed3f35", "#33f310"],
    tooltip: {
      // 通过坐标轴来触发
      trigger: "axis"
    },
    legend: {
      // 距离容器10%
      right: "10%",
      // 修饰图例文字的颜色
      textStyle: {
        color: "#ffffff"
      }
    },
    grid: {
      top: "20%",
      left: "3%",
      right: "4%",
      bottom: "3%",
      show: true,
      borderColor: "#012f4a",
      containLabel: true
    },

    xAxis: {
      interval:0,
      type: "category",
      boundaryGap: false,
      data: [],
      // 去除刻度
      axisTick: {
        show: false
      },
      // 修饰刻度标签的颜色
      axisLabel: {
        interval: 0,
        color: "rgba(255,255,255)"
      },
      // 去除x坐标轴的颜色
      axisLine: {
        show: false
      }
    },
    yAxis: {
      type: "value",
      // 去除刻度
      axisTick: {
        show: false
      },
      // 修饰刻度标签的颜色
      axisLabel: {
        color: "rgba(255,255,255)"
      },
      // 修改y轴分割线的颜色
      splitLine: {
        lineStyle: {
          color: "#012f4a"
        }
      }
    },
    series: [
      {
        name: "新增粉丝",
        type: "line",
        stack: "总量",
        // 是否让线条圆滑显示
        smooth: true,
        data: []
      },
      {
        name: "新增游客",
        type: "line",
        stack: "总量",
        smooth: true,
        data: []
      },
      {
        name: "",
        type: "line",
        stack: "总量",
        smooth: true,
        data: []
      }
    ]
  };
  // 3. 把配置和数据给实例对象
  myChart.setOption(option);

  // 定义x、y轴数据数组
  var fruitsNames=[];
  var fruitsMaxPrices=[];
  var fruitsAvgPrices=[];
  var fruitsMinPrices=[];
  //请求后台数据
  $.ajax({
    type: "get",
    url: "/FruitsCleanPrice/list",
    contentType: "application/json",
    success: function(res){
      console.log("=====res: =======")
      console.log(res);
      for (var i = 0; i < res.length ; i++) {
        fruitsNames.push(res[i].fruitsName);
        fruitsMaxPrices.push(res[i].fruitsMaxPrice);
        fruitsAvgPrices.push(res[i].fruitsAvgPrice);
        fruitsMinPrices.push(res[i].fruitsMinPrice);
      }
      myChart.setOption({
        xAxis: [{
          data: fruitsNames
        }],
        series: [{
          // 根据名字对应到相应的系列
          name: 'minPrice',
          data: fruitsMinPrices
          },{
          // 根据名字对应到相应的系列
          name: 'avgPrice',
          data: fruitsAvgPrices
        },{
          // 根据名字对应到相应的系列
          name: 'maxPrice',
          data: fruitsMaxPrices
        }
        ]
      });
    }
  });
  // 使用刚指定的配置项和数据显示图表。
  myChart.setOption(option);
  window.addEventListener("resize", function() {
    myChart.resize();
  });
})();

// 3饼形图定制
(function() {
  // 基于准备好的dom，初始化echarts实例
  var myChart = echarts.init(document.querySelector(".pie .chart"));

  option = {
    tooltip: {
      trigger: "item",
      formatter: "{a} <br/>{b}: {c} ({d}%)",
      position: function(p) {
        //其中p为当前鼠标的位置
        return [p[0] + 10, p[1] - 10];
      }
    },
    legend: {
      top: "90%",
      itemWidth: 10,
      itemHeight: 10,
      data: ["0岁以下", "20-29岁", "30-39岁", "40-49岁", "50岁以上"],
      textStyle: {
        color: "rgba(255,255,255)",
        fontSize: "12"
      }
    },
    series: [
      {
        name: "年龄分布",
        type: "pie",
        center: ["50%", "42%"],
        radius: ["40%", "60%"],
        color: [
          "#1089E7",
          "#f57474",
          "#56D0E3",
          "#F8B448",
          "#8B78F6",
        ],
        label: { show: false },
        labelLine: { show: false },
        data: []
      }
    ]
  };

  // 定义x、y轴数据数组
  var species=[];
  var numbers=[];
  //请求后台数据
  $.ajax({
    type: "get",
    url: "/shellRequests/list",
    contentType: "application/json",
    success: function(res){
      console.log("=====res: =======")
      console.log(res);
      for (var i = 0; i < res.length ; i++) {
        species.push(res[i].specie);
        numbers.push(res[i].number);
      }
      myChart.setOption({
        legend: {
          data: species,
          },
        series: [
          {
            name: "海水贝类需求量",
            data: [
              { value: numbers[0], name: species[0] },
              { value: numbers[1], name: species[1] },
              { value: numbers[2], name: species[2] },
              { value: numbers[3], name: species[3] },
              { value: numbers[4], name: species[4] }
            ]
          }
        ]
      });
    }
  });
  // 使用刚指定的配置项和数据显示图表。
  myChart.setOption(option);
  window.addEventListener("resize", function() {
    myChart.resize();
  });
})();

// 4柱状图模块
(function() {
  // 基于准备好的dom，初始化echarts实例
  var myChart = echarts.init(document.querySelector(".bar1 .chart"));

  var data = [70, 34, 60, 78, 69];
  var titlename = ["HTML5", "CSS3", "javascript", "VUE", "NODE"];
  var valdata = [702, 350, 610, 793, 664];
  var myColor = ["#1089E7", "#f57474", "#56D0E3", "#F8B448", "#8B78F6"];
  option = {
    //图标位置
    grid: {
      top: "10%",
      left: "22%",
      bottom: "10%"
    },
    xAxis: {
      show: false
    },
    yAxis: [
      {
        show: true,
        data: titlename,
        inverse: true,
        axisLine: {
          show: false
        },
        splitLine: {
          show: false
        },
        axisTick: {
          show: false
        },
        axisLabel: {
          color: "#fff",

          rich: {
            lg: {
              backgroundColor: "#339911",
              color: "#fff",
              borderRadius: 15,
              // padding: 5,
              align: "center",
              width: 15,
              height: 15
            }
          }
        }
      },
      {
        show: true,
        inverse: true,
        data: valdata,
        axisLabel: {
          textStyle: {
            fontSize: 12,
            color: "#fff"
          }
        }
      }
    ],
    series: [
      {
        name: "条",
        type: "bar",
        yAxisIndex: 0,
        data: data,
        barCategoryGap: 50,
        barWidth: 10,
        itemStyle: {
          normal: {
            barBorderRadius: 20,
            color: function(params) {
              var num = myColor.length;
              return myColor[params.dataIndex % num];
            }
          }
        }
      },
      {
        name: "框",
        type: "bar",
        yAxisIndex: 1,
        barCategoryGap: 50,
        data: [100, 100, 100, 100, 100],
        barWidth: 15,
        itemStyle: {
          normal: {
            color: "none",
            borderColor: "#00c1de",
            borderWidth: 3,
            barBorderRadius: 15
          }
        }
      }
    ]
  };

  var species=[];
  var numbers=[];
  //请求后台数据
  $.ajax({
    type: "get",
    url: "/meatSupply/list",
    contentType: "application/json",
    success: function(res){
      console.log("=====res: =======")
      console.log(res);
      for (var i = 0; i < res.length ; i++) {
        species.push(res[i].specie);
        numbers.push(res[i].number);
      }
      myChart.setOption({
        yAxis: [
          {
            data: species
          },{
            data: numbers
          }],
        series: [
          {
            data: numbers
          }
        ]

      });
    }
  });
  // 使用刚指定的配置项和数据显示图表。
  myChart.setOption(option);
  window.addEventListener("resize", function() {
    myChart.resize();
  });
})();

// 5折线图 优秀作品
(function() {
  // 基于准备好的dom，初始化echarts实例
  var myChart = echarts.init(document.querySelector(".line1 .chart"));

  option = {
    tooltip: {
      trigger: "axis",
      axisPointer: {
        lineStyle: {
          color: "#dddc6b"
        }
      }
    },
    legend: {
      top: "0%",
      textStyle: {
        color: "rgba(255,255,255)",
        fontSize: "12"
      }
    },
    grid: {
      left: "10",
      top: "30",
      right: "10",
      bottom: "10",
      containLabel: true
    },

    xAxis: [
      {
        type: "category",
        boundaryGap: false,
        axisLabel: {
          textStyle: {
            color: "rgba(255,255,255)",
            fontSize: 12
          }
        },
        axisLine: {
          lineStyle: {
            color: "rgba(255,255,255,.2)"
          }
        },

        data: []

      },
      {
        axisPointer: { show: false },
        axisLine: { show: false },
        position: "bottom",
        offset: 20
      }
    ],

    yAxis: [
      {
        type: "value",
        axisTick: { show: false },
        axisLine: {
          lineStyle: {
            color: "rgba(255,255,255,.1)"
          }
        },
        axisLabel: {
          textStyle: {
            color: "rgba(255,255,255)",
            fontSize: 12
          }
        },

        splitLine: {
          lineStyle: {
            color: "rgba(255,255,255,.1)"
          }
        }
      }
    ],
    series: [
      {
        name: "播放量",
        type: "line",
        smooth: true,
        symbol: "circle",
        symbolSize: 5,
        showSymbol: false,
        lineStyle: {
          normal: {
            color: "#0184d5",
            width: 2
          }
        },
        areaStyle: {
          normal: {
            color: new echarts.graphic.LinearGradient(
              0,
              0,
              0,
              1,
              [
                {
                  offset: 0,
                  color: "rgba(1, 132, 213, 0.4)"
                },
                {
                  offset: 0.8,
                  color: "rgba(1, 132, 213, 0.1)"
                }
              ],
              false
            ),
            shadowColor: "rgba(0, 0, 0, 0.1)"
          }
        },
        itemStyle: {
          normal: {
            color: "#0184d5",
            borderColor: "rgba(221, 220, 107, .1)",
            borderWidth: 12
          }
        },
        data: []
      },
      {
        name: "转发量",
        type: "line",
        smooth: true,
        symbol: "circle",
        symbolSize: 5,
        showSymbol: false,
        lineStyle: {
          normal: {
            color: "#00d887",
            width: 2
          }
        },
        areaStyle: {
          normal: {
            color: new echarts.graphic.LinearGradient(
              0,
              0,
              0,
              1,
              [
                {
                  offset: 0,
                  color: "rgba(0, 216, 135, 0.4)"
                },
                {
                  offset: 0.8,
                  color: "rgba(0, 216, 135, 0.1)"
                }
              ],
              false
            ),
            shadowColor: "rgba(0, 0, 0, 0.1)"
          }
        },
        itemStyle: {
          normal: {
            color: "#00d887",
            borderColor: "rgba(221, 220, 107, .1)",
            borderWidth: 12
          }
        },
        data: []
      }
    ]
  };

  // 定义x、y轴数据数组
  var cityShorts=[];
  var maxPrices=[];
  var minPrices=[];
  //请求后台数据
  $.ajax({
    type: "get",
    url: "/cityNumberClean/list",
    contentType: "application/json",
    success: function(res){
      console.log("=====res: =======")
      console.log(res);
      for (var i = 0; i < res.length ; i++) {
        cityShorts.push(res[i].cityShort);
        maxPrices.push(res[i].maxPrice);
        minPrices.push(res[i].minPrice);
      }
      myChart.setOption({
        xAxis: [
          {
            type: "category",
            data: cityShorts
          },
        ],

        series: [
          {
            name: "maxPrice",
            data: maxPrices
          },
          {
            name: "minPrice",
            data: minPrices
          }
        ]
      });
    }
  });

  // 使用刚指定的配置项和数据显示图表。
  myChart.setOption(option);
  window.addEventListener("resize", function() {
    myChart.resize();
  });
})();

// 6点位分布统计模块
(function() {
  // 1. 实例化对象
  var myChart = echarts.init(document.querySelector(".pie1  .chart"));
  // 2. 指定配置项和数据
  var option = {
    legend: {
      top: "85%",
      itemWidth: 10,
      itemHeight: 10,
      textStyle: {
        color: "rgba(255,255,255)",
        fontSize: "12"
      }
    },
    tooltip: {
      trigger: "item",
      formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    // 注意颜色写的位置
    color: [
      "#006cff",
      "#60cda0",
      "#ed8884",
      "#ff9f7f",
      "#0096ff",
      "#9fe6b8",
      "#32c5e9",
      "#1d9dff"
    ],
    series: [
      {
        name: "点位统计",
        type: "pie",
        // 如果radius是百分比则必须加引号
        radius: ["10%", "70%"],
        center: ["50%", "42%"],
        roseType: "radius",
        data: [],
        // 修饰饼形图文字相关的样式 label对象
        label: {
          fontSize: 10
        },
        // 修饰引导线样式
        labelLine: {
          // 连接到图形的线长度
          length: 10,
          // 连接到文字的线长度
          length2: 10
        }
      }
    ]
  };

  // 定义x、y轴数据数组
  var citys=[];
  var nums=[];
  //请求后台数据
  $.ajax({
    type: "get",
    url: "/cityNumberClean/list",
    contentType: "application/json",
    success: function(res){
      console.log("=====res: =======")
      console.log(res);
      for (var i = 0; i < res.length ; i++) {
        citys.push(res[i].city);
        nums.push(res[i].num);
      }
      myChart.setOption({
        series: [
          {
            name: "绿豆",
            data: [
              { value: nums[11], name: citys[11] },
              { value: nums[10], name: citys[10] },
              { value: nums[9], name: citys[9] },
              { value: nums[8], name: citys[8] },
              { value: nums[7], name: citys[7] },
              { value: nums[6], name: citys[6] }
            ]}
        ]
      });
    }
  });

  // 3. 配置项和数据给我们的实例化对象
  myChart.setOption(option);
  // 4. 当我们浏览器缩放的时候，图表也等比例缩放
  window.addEventListener("resize", function() {
    // 让我们的图表调用 resize这个方法
    myChart.resize();
  });
})();

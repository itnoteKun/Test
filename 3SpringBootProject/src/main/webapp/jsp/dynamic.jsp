<%--
  Created by IntelliJ IDEA.
  User: 28753
  Date: 2022/5/20
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
THIS EXAMPLE WAS DOWNLOADED FROM https://echarts.apache.org/examples/zh/editor.html?c=doc-example%2Ftutorial-dynamic-data&random=pcieq3fszx
-->
<!DOCTYPE html>
<html lang="zh-CN" style="height: 100%">
<head>
    <meta charset="utf-8">
</head>
<body style="height: 100%; margin: 0">
<div id="container" style="height: 100%"></div>


<script type="text/javascript" src="https://fastly.jsdelivr.net/npm/echarts@5.3.2/dist/echarts.min.js"></script>
<script src="/js/jquery-3.5.1.min.js"></script>

<!-- Uncomment this line if you want to dataTool extension
<script type="text/javascript" src="https://fastly.jsdelivr.net/npm/echarts@5.3.2/dist/extension/dataTool.min.js"></script>
-->
<!-- Uncomment this line if you want to use gl extension
<script type="text/javascript" src="https://fastly.jsdelivr.net/npm/echarts-gl@2/dist/echarts-gl.min.js"></script>
-->
<!-- Uncomment this line if you want to echarts-stat extension
<script type="text/javascript" src="https://fastly.jsdelivr.net/npm/echarts-stat@latest/dist/ecStat.min.js"></script>
-->
<!-- Uncomment this line if you want to use map
<script type="text/javascript" src="https://fastly.jsdelivr.net/npm/echarts@4.9.0/map/js/china.js"></script>
<script type="text/javascript" src="https://fastly.jsdelivr.net/npm/echarts@4.9.0/map/js/world.js"></script>
-->
<!-- Uncomment these two lines if you want to use bmap extension
<script type="text/javascript" src="https://api.map.baidu.com/api?v=3.0&ak=YOUR_API_KEY"></script>
<script type="text/javascript" src="https://fastly.jsdelivr.net/npm/echarts@5.3.2/dist/extension/bmap.min.js"></script>
-->

<script type="text/javascript">
    // 定义x、y轴数据数组
    var data = [];
    var date=[];

    var dom = document.getElementById('container');
    var myChart = echarts.init(dom, 'dark', {
        renderer: 'canvas',
        useDirtyRect: false

    })



    var app = {};

    var option;

    function addData(shift) {
        if (shift) {
            date.shift();
            data.shift();
        }
    }

    setInterval(function () {
        addData(true);
        myChart.setOption({
            xAxis: {
                data: date
            },
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: 'data',
                    data: data
                }
            ]
        });
    }, 500);

    option = {
        title: {
            left: 10,
            top: 20,
            itemGap:30,
            text: '带鱼均价动态信息展示',
            subtarget: 'self',
            subtext: '农作物价格详细信息展示',
            sublink: 'http://localhost:8082/admin/pricePage',
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: date
        },
        yAxis: {
            boundaryGap: [0, '50%'],
            type: 'value'
        },
        series: [
            {
                name: 'data',
                type: 'line',
                smooth: true,
                symbol: 'circle',
                stack: 'a',
                //itemStyle : { normal: {label : {show: true}}},
                areaStyle: {
                    normal: {}
                },
                data: data
            }
        ]
    };



    //请求后台数据
    $.ajax({
        type: "get",
        url: "/dynamic/list",
        contentType: "application/json",
        success: function (res) {
            console.log("=====res: =======")
            console.log(res);
            for (var i = 0; i < res.length; i++) {
                date.push(res[i].date);
                data.push(res[i].avgPrice);

            }
            myChart.setOption({
                xAxis: [{
                    data: date
                }],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [{
                    // 根据名字对应到相应的系列
                    name: 'avgPrice',
                    data: data
                }]
            });

        }

    })

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);


    if (option && typeof option === 'object') {
        myChart.setOption(option);
    }

    window.addEventListener('resize', myChart.resize);
</script>
</body>
</html>
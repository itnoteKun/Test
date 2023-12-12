<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/5/20
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN" style="height: 100%">
<head>
    <meta charset="utf-8">
</head>
<body style="height: 100%; margin: 0">
<div id="container" style="height: 100%"></div>


<script type="text/javascript" src="https://fastly.jsdelivr.net/npm/echarts@5.3.2/dist/echarts.min.js"></script>
<script src="/js/jquery-3.5.1.min.js"></script>

<script type="text/javascript">
    var dom = document.getElementById('container');
    var myChart = echarts.init(dom, "dark", {
        renderer: 'canvas',
        useDirtyRect: false
    });
    var app = {};
    var ROOT_PATH = 'https://fastly.jsdelivr.net/gh/apache/echarts-website@asf-site/examples';
    var option;

    const weatherIcons = {
        Sunny: ROOT_PATH + '/data/asset/img/weather/sunny_128.png',
        Cloudy: ROOT_PATH + '/data/asset/img/weather/cloudy_128.png',
        Showers: ROOT_PATH + '/data/asset/img/weather/showers_128.png'
    };
    option = {
        // title: {
        //     top:20,
        //     text: '各类蔬菜需求量占比',
        //     left: 'center'
        // },
        title: {
            left: 10,
            top: 20,
            itemGap:30,
            text: '各类蔬菜需求量占比',
            subtarget: 'self',
            subtext: '带鱼均价动态信息展示',
            sublink: 'http://localhost:8082/admin/dynamicPage',
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
            bottom: 10,
            left: 'center',
            data: []
        },
        series: [
            {
                type: 'pie',
                radius: '65%',
                center: ['50%', '50%'],
                selectedMode: 'single',
                data: [],
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };



    // 定义x、y轴数据数组
    var specie=[];
    var number=[];
    $.ajax({
        type: "get",
        url: "/vegetablesRequests/list",
        contentType: "application/json",
        success: function(res){
            console.log("=====res: =======")
            console.log(res);
            for (var i = 0; i < res.length ; i++) {
                specie.push(res[i].specie);
                number.push(res[i].number);
            }
            myChart.setOption({
                legend: [{
                    data: specie
                }],
                series: [{
                    // 根据名字对应到相应的系列
                    //["#1089E7", "#f57474", "#56D0E3", "#F8B448", "#8B78F6"
                    name: '蔬菜需求量占比',
                    data: [
                        { value: number[0], name: specie[0] },
                        { value: number[1], name: specie[1] },
                        { value: number[2], name: specie[2] },
                        { value: number[3], name: specie[3] },
                        { value: number[4], name: specie[4] },
                        { value: number[5], name: specie[5] },
                        { value: number[6], name: specie[6] },
                        { value: number[7], name: specie[7] },
                        { value: number[8], name: specie[8] },
                        { value: number[9], name: specie[9] },
                        { value: number[10], name: specie[10] },
                        { value: number[11], name: specie[11] },
                        { value: number[12], name: specie[12] },
                        { value: number[13], name: specie[13] },
                        { value: number[14], name: specie[14] },
                        { value: number[15], name: specie[15] },
                        { value: number[16], name: specie[16] },
                        { value: number[17], name: specie[17] },
                        { value: number[18], name: specie[18] },
                        { value: number[19], name: specie[19] },
                        { value: number[20], name: specie[20] },
                        { value: number[21], name: specie[21] },
                        { value: number[22], name: specie[22] },
                        { value: number[23], name: specie[23] },
                        { value: number[24], name: specie[24] },
                        { value: number[25], name: specie[25] },
                        { value: number[26], name: specie[26] },
                        { value: number[27], name: specie[27] },
                        { value: number[28], name: specie[28] },
                        { value: number[29], name: specie[29] },
                        { value: number[30], name: specie[30] },
                        { value: number[31], name: specie[31] },
                        { value: number[32], name: specie[32] },
                        { value: number[33], name: specie[33] },
                        { value: number[34], name: specie[34] },
                        { value: number[35], name: specie[35] },
                    ],
                },
                ]
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

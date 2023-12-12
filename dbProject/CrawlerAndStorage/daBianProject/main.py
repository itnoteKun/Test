import getWebData
import dbConnect
import time

if __name__ =="__main__":

    #省到省会的映射
    proToCity = {
        "山西" : "太原",
        "北京" : "北京",
        "浙江" : "杭州",
        "天津" : "天津",
        "安徽" : "合肥",
        "上海" : "上海",
        "福建" : "福州",
        "重庆" : "重庆",
        "江西" : "南昌",
        "香港" : "香港",
        "山东" : "济南",
        "澳门" : "澳门",
        "河南" : "郑州",
        "内蒙古" : "呼和浩特",
        "湖北" : "武汉",
        "新疆" : "乌鲁木齐",
        "湖南" : "长沙",
        "辽宁" : "沈阳",
        "黑龙江" : "哈尔滨",
        "江苏" : "南京",
        "广东" : "广州",
        "陕西" : "西安",
        "四川" : "成都",
        "贵州" : "贵阳",
        "青海" : "西宁",
        "甘肃" : "兰州",
        "广西" : "南宁",
        "宁夏" : "银川",
        "西藏" : "拉萨",
        "台湾" : "台北",
        "河北" : "石家庄",
        "云南" : "昆明",
        "吉林" : "长春",
        "海南" : "海口"
    }

    #省会到拼音的映射
    cityToPin = {
        "太原" : "taiyuan",
        "北京" : "beijing",
        "杭州" : "hangzhou",
        "天津" : "tianjin",
        "合肥" : "hefei",
        "上海" : "shanghai",
        "福州" : "fuzhou",
        "重庆" : "chongqing",
        "南昌" : "nanchang",
        "香港" : "hongkong",
        "济南" : "jinan",
        "澳门" : "aomen",
        "郑州" : "zhengzhou",
        "呼和浩特" : "huhehaote",
        "武汉" : "wuhan",
        "乌鲁木齐" : "wulumuqi",
        "长沙" : "changsha",
        "沈阳" : "shenyang",
        "哈尔滨" : "haerbin",
        "南京" : "nanjing",
        "广州" : "guangzhou",
        "西安" : "xian",
        "成都" : "chengdu",
        "贵阳" : "guiyang",
        "西宁" : "xining",
        "兰州" : "lanzhou",
        "南宁" : "nanning",
        "银川" : "yinchuan",
        "拉萨" : "lasa",
        "台北" : "taibei",
        "石家庄" : "shijiazhuang",
        "昆明" : "kunming",
        "长春" : "changchun",
        "海口" : "haikou"
   }

    #时间列表,最近一年
    timeList = ["202304","202303","202302","202301","202212","202211",
                "202210","202209","202208","202207","202206","202205"]

    keyword = ""

    # 建立与数据库的连接
    conn = dbConnect.dbConnect()
    conn.db_init()
    conn.setChar()

    # 循环获取数据
    index = 1
    for key in proToCity.keys():
        city = proToCity[key]
        keyword = cityToPin[city]
        for time1 in timeList:
            try :
                if index == 1:
                    getWebDataIns = getWebData.webCrawler(keyword, time1, key, city)
                else:
                    getWebDataIns.keyWord = keyword
                    getWebDataIns.weatherTime = time1
                    getWebDataIns.province = key
                    getWebDataIns.city = city
                getWebDataIns.completeUrl()
                response = getWebDataIns.getResponse()
                data = getWebDataIns.getData(response)

                # 数据入库
                for dt in data :
                    conn.dataInsert(dt)
                # 等待两秒，防止太频繁被封
                time.sleep(1)
                index += 1
            except:
                pass
    conn.cur_Close()
    conn.con_Close()
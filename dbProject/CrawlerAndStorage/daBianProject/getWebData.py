import requests
from lxml import etree

class webCrawler :

    def __init__(self, keyword, time, key, city):
        self.baseUrl = "https://lishi.tianqi.com/"
        self.endUrl = ".html"
        self.fullUrl = ""
        self.heahers = {
            "User-Agent" : "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36 Edg/112.0.1722.48"
        }
        self.keyWord = keyword
        self.weatherTime = time
        self.province = key
        self.city = city

    #组合url
    def completeUrl(self):
        self.fullUrl = self.baseUrl+self.keyWord+"/"+self.weatherTime+self.endUrl

    #获取response，提取页面内容
    def getResponse(self):
        print(self.fullUrl)
        response = requests.get(url=self.fullUrl,headers=self.heahers,timeout=30)
        if  response.status_code == 200 :
            return response
        else:
            print(response.status_code)

    #获取数据
    def getData(self,response):
        htmlTree = etree.HTML(response.text)
        dataLiAll = htmlTree.xpath("/html/body/div[7]/div[1]/div[4]/ul/li")
        dataListAll = []
        for dataLi in dataLiAll :
            dataList = []
            data = dataLi.xpath("./div/text()")
            date = data[0]
            tempMax = data[1].replace("℃","")
            tempMin = data[2].replace("℃","")
            weather = data[3]
            windDir = data[4].split(" ")[0]
            windLevel = data[4].split(" ")[1][0]
            splitWord = date.split(" ")
            year = splitWord[0].split("-")[0]
            month = splitWord[0].split("-")[1]
            day = splitWord[0].split("-")[2]
            week = splitWord[1]
            dataList = [self.province, self.city, year, month, day, week, tempMax, tempMin, weather, windDir, windLevel]
            dataListAll.append(dataList)
        return dataListAll




import pymysql

class dbConnect :

    # 初始化
    def __init__(self):
        self.host = "192.168.10.101"
        self.userName = "root"
        self.password = "120710"
        self.charset='UTF8'
        self.database = "dbAnalysis"
        self.connect = pymysql.connect(host=self.host,
                                       user=self.userName,
                                       password=self.password,
                                       database=self.database,
                                       charset=self.charset)
        self.cursor = self.connect.cursor()

    # 建表
    def db_init(self):
        self.cursor.execute("""
                CREATE TABLE IF NOT EXISTS cityWeather (
                id INTEGER PRIMARY KEY AUTO_INCREMENT,
                province TEXT,
                city TEXT,
                year TEXT,
                month TEXT,
                day TEXT,
                week TEXT,
                tempMax TEXT,
                tempMin TEXT,
                weather TEXT,
                windDir TEXT,
                windLevel TEXT
            );
            """)

    # 插入数据
    def dataInsert(self,data):
        sql = """
        insert into cityWeather (province, city, year, month, day, week, tempMax, tempMin, weather, windDir, windLevel)
            values (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s);
        """
        self.cursor.execute(sql, data)
        self.connect.commit()

    # 关闭连接
    def con_Close(self):
        self.connect.close()

    #关闭游标
    def cur_Close(self):
        self.cursor.close()

    # 设置字段及表编码类型
    def setChar(self):
        sqlCommonds = """
        alter table cityWeather character set utf8;
        alter table cityWeather change province province text character set utf8;
        alter table cityWeather change city city text character set utf8;
        alter table cityWeather change year year text character set utf8;
        alter table cityWeather change month month text character set utf8;
        alter table cityWeather change day day text character set utf8;
        alter table cityWeather change week week text character set utf8;
        alter table cityWeather change tempMax tempMax text character set utf8;
        alter table cityWeather change tempMin tempMin text character set utf8;
        alter table cityWeather change weather weather text character set utf8;
        alter table cityWeather change windDir windDir text character set utf8;
        alter table cityWeather change windLevel windLevel text character set utf8;
        """
        sqlList = sqlCommonds.replace("\n        ","").split(";")
        for sql in sqlList :
            if sql == '' :
                continue
            self.cursor.execute(sql)
            self.connect.commit()
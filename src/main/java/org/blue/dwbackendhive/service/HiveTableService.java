package org.blue.dwbackendhive.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HiveTableService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createTables() {
        // 1. 创建 Movie 表
        // 1. 创建 Movie 表
        /*String createMovieTable = """
        CREATE TABLE IF NOT EXISTS movie (
            movie_id BIGINT,
            title STRING,
            runtime INT,
            comments INT,
            type STRING,
            grade FLOAT,
            year INT,
            month INT,
            day INT
        )
        ROW FORMAT DELIMITED
        FIELDS TERMINATED BY ','
        STORED AS TEXTFILE
    """;

// 2. 创建 Person 表
        String createPersonTable = """
        CREATE TABLE IF NOT EXISTS person (
            person_id BIGINT,
            name STRING
        )
        ROW FORMAT DELIMITED
        FIELDS TERMINATED BY ','
        STORED AS TEXTFILE
    """;

// 3. 创建 Product 表
        String createProductTable = """
        CREATE TABLE IF NOT EXISTS product (
            ASIN STRING,
            Format STRING,
            Grade FLOAT,
            Cost FLOAT,
            movie_id BIGINT
        ) 
        ROW FORMAT DELIMITED
        FIELDS TERMINATED BY ',' 
        STORED AS TEXTFILE
    """;

// 4. 创建 Direct 表
        String createDirectTable = """
        CREATE TABLE IF NOT EXISTS direct (
            movie_id BIGINT,
            person_id BIGINT
        ) 
        ROW FORMAT DELIMITED
        FIELDS TERMINATED BY ',' 
        STORED AS TEXTFILE
    """;

// 5. 创建 Act 表
        String createActTable = """
        CREATE TABLE IF NOT EXISTS act (
            movie_id BIGINT,
            person_id BIGINT,
            id_starring VARCHAR(1)
        ) 
        ROW FORMAT DELIMITED
        FIELDS TERMINATED BY ',' 
        STORED AS TEXTFILE
    """;

// 6. 创建 AAcoop_time 表
        String createAAcoopTimeTable = """
        CREATE TABLE IF NOT EXISTS AAcoop_time (
            first_person_id BIGINT,
            second_person_id BIGINT,
            type VARCHAR(2),
            time INT,
            movie_id ARRAY<BIGINT>
        ) 
        ROW FORMAT DELIMITED
        FIELDS TERMINATED BY '~' 
        COLLECTION ITEMS TERMINATED BY ','
        STORED AS TEXTFILE
    """;

// 7. 创建 DAcoop_time 表
        String createDAcoopTimeTable = """
        CREATE TABLE IF NOT EXISTS DAcoop_time (
            first_person_id BIGINT,
            second_person_id BIGINT,
            type VARCHAR(2),
            time INT,
            movie_id ARRAY<BIGINT>
        ) 
        ROW FORMAT DELIMITED
        FIELDS TERMINATED BY '~' 
        COLLECTION ITEMS TERMINATED BY ','
        STORED AS TEXTFILE
    """;

// 执行建表语句
        jdbcTemplate.execute(createMovieTable);
        jdbcTemplate.execute(createPersonTable);
        jdbcTemplate.execute(createProductTable);
        jdbcTemplate.execute(createDirectTable);
        jdbcTemplate.execute(createActTable);
        jdbcTemplate.execute(createAAcoopTimeTable);
        jdbcTemplate.execute(createDAcoopTimeTable);

        //jdbcTemplate.execute("TRUNCATE TABLE aacoop_time");
        System.out.println("All tables created successfully.");*/

    }
}
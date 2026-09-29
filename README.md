# F.CSA313 — Лаборатори №4: Нэгжийн тестийн эхлэл — JUnit 5

> **B232270019 О. Оюунжаргал**

## Хөгжүүлэлтийн орчин

### `java -version`

```text
openjdk version "21.0.11" 2026-04-21
OpenJDK Runtime Environment Homebrew (build 21.0.11)
OpenJDK 64-Bit Server VM Homebrew (build 21.0.11, mixed mode, sharing)
```

### `mvn -version`

```text
Apache Maven 3.9.16 (2bdd9fddda4b155ebf8000e807eb73fd829a51d5)
Maven home: /opt/homebrew/Cellar/maven/3.9.16/libexec
Java version: 21.0.11, vendor: Homebrew, runtime: /usr/local/Cellar/openjdk@21/21.0.11/libexec/openjdk.jdk/Contents/Home
Default locale: en_MN, platform encoding: UTF-8
OS name: "mac os x", version: "26.6", arch: "x86_64", family: "mac"
```

## Тестийн үр дүн

`GradeCalculatorTest` класс нийт 8 тестийн методтой. `results/mvn-test.txt` тайланд 17 run бүгд амжилттай, failure болон error байхгүй, skipped тестгүй гэж гарч `BUILD SUCCESS` болсон. Мутацийн туршилтын `results/mvn-test-mutant.txt` тайланд 17 run хийснээс 1 тест унаж `BUILD FAILURE` болсон.

Мутацийн туршилтаар `letterGrade` доторх `score >= 90` нөхцөлийг `score > 90` болгож өөрчлөхөд `GradeCalculatorTest.letterGradeTest(double, String)[2]` тест унасан. Тайланд `90` оноонд хүлээгдсэн `A`-гийн оронд `B` гарсан бөгөөд туршилтын дараа нөхцөлийг `score >= 90` болгон сэргээсэн. 

## Дүгнэлт

Энэхүү лабораторийн ажлаар Maven төсөлд JUnit 5 хүрээг амжилттай холбож, орчин үеийн нэгжийн тест болон параметржүүлсэн тест бичих чадварыг бүрэн эзэмшиж авлаа. GradeCalculator классыг ашиглан ердийн болон хязгаарын утгуудыг нарийвчлан шалгаж, assertThrows ашиглан буруу оролтын үед IllegalArgumentException зөв шидэгдэж байгааг баталгаажуулсан нь програм хангамжийн чанарын баталгаажуулалтад нэгжийн тест ямар чухал болохыг бодитойгоор ойлгууллаа. x
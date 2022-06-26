# yandex-backend
Тестовое задание в школу бэкенд разработки Yandex 2022 (Веб-сервис сравнения цен).<br />
Реализованы апи методы:
##/imports
   пример запроса: https://ben-2023.usr.yandex-academy.ru/imports
   ```
{
        "items": [
            {
                "type": "OFFER",
                "name": "маяк",
                "id": "1ac0129a-2bfe-474c-9ee6-d435bf5fc8f2",
                "parentId": "1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2",
                "price": 1
            }
        ],
        "updateDate": "2022-06-26T11:34:10.000Z"
}
   ```
   пример ответа:
   ```
   {
       "code": 200,
       "message": "Imports done successfully"
   }
   ```
##/delete/{id}
   пример запроса: https://ben-2023.usr.yandex-academy.ru/delete/069cb8d7-bbdd-47d3-ad8f-82ef4c269df1
   <br />пример ответа:
   ```
{
    "code": 200,
    "message": "Delete done successfully"
}
   ```
##/nodes/{id}
   пример запроса: https://ben-2023.usr.yandex-academy.ru/nodes/069cb8d7-bbdd-47d3-ad8f-82ef4c269df1
   <br />пример ответа:
   ```
{
    "id": "74b81fda-9cdc-4b63-8927-c978afed5cf4",
    "name": "Phyllis 50\" LED UHD Smarter",
    "date": "2022-02-03T12:00:00.000Z",
    "parentId": "1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2",
    "type": "OFFER",
    "price": 49999,
    "children": null
}
   ```
##/sales
   пример запроса: https://ben-2023.usr.yandex-academy.ru/sales
  <br /> с параметрами: https://ben-2023.usr.yandex-academy.ru/sales?date=2022-02-02T12:00:00.000Z
   <br />пример ответа:
   ```
{
    "items": [
        {
            "id": "98883e8f-0507-482f-bce2-2fb306cf6483",
            "name": "Samson 70\" LED UHD Smart",
            "parentId": "1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2",
            "type": "OFFER",
            "price": 32999,
            "date": "2022-02-03T12:00:00.000Z"
        },
        {
            "id": "74b81fda-9cdc-4b63-8927-c978afed5cf4",
            "name": "Phyllis 50\" LED UHD Smarter",
            "parentId": "1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2",
            "type": "OFFER",
            "price": 49999,
            "date": "2022-02-03T12:00:00.000Z"
        },
        {
            "id": "73bc3b36-02d1-4245-ab35-3106c9ee1c65",
            "name": "Goldstar 65\" LED UHD LOL Very Smart",
            "parentId": "1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2",
            "type": "OFFER",
            "price": 69999,
            "date": "2022-02-03T15:00:00.000Z"
        }
    ]
}
   ```

##/node/{id}/statistic
   пример запроса: http://localhost:80/node/1ac0129a-2bfe-474c-9ee6-d435bf5fc8f2/statistic
  <br /> с параметрами: http://localhost:8089/node/99bc3b31-02d1-4245-ab35-3106c9ee1c65/statistic?dateStart=2022-02-01T00:00:00.000Z&dateEnd=2022-06-03T15:30:00.000Z
   <br />пример ответа:
   ```
{
    "items": [
        {
            "id": "1ac0129a-2bfe-474c-9ee6-d435bf5fc8f2",
            "name": "Goldstar 65",
            "parentId": "1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2",
            "type": "OFFER",
            "price": 1110,
            "date": "2022-06-26T11:36:10.000Z"
        },
        {
            "id": "1ac0129a-2bfe-474c-9ee6-d435bf5fc8f2",
            "name": "Goldstar 65",
            "parentId": "1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2",
            "type": "OFFER",
            "price": 10,
            "date": "2022-06-26T11:35:10.000Z"
        }
    ]
}
   ```
**Inventory APIs Detail**


---

## POST API

JSON PAYLOAD STRUCTURE IS:

{
  "manufacturer": {
    "id" : "1" // already in database
  },
  "name": "guitar",
  "releaseDate": "2018-01-01T02:10:00.040Z"
}

---

## GET ALL INVENTORY

1. Call inventory GET API without query parameter and get all inventories

2. Call inventory API with skip and limit query parameter and get specified results.

---

## GET INVENTORY BY ID

This API will provide you inventory by id value.



 
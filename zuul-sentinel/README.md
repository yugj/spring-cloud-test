**test**  
```
curl -H "h-xx: 1" -H "Content-Type: application/json" localhost:9017/rest-sv/hell -d '{
   "hellReq":"hell"
   }'
```

**console server**  
```
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar

```


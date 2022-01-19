### 데이터 처리 컴포넌트

```javascript
render() {
    return this.$scopedSlots.default({
        response: ~~,
        loading: ~~
    })   
}
```

```html
<fetch-data>
  <div slot-scope="{ response, loading }">
    <div v-if="!loading">
      <p>response</p>
    </div>
    <div v-if="loading">
      Loading...
    </div>
  </div>
</fetch-data>

```


```js
var accounts = require("ti.accounts");
accounts.addEventListener("accounts",function(e){
	console.log(e.accounts);
})
accounts.getAccounts();
```

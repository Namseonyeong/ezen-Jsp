/**
 * 0527
 */
function productCheck() {
	var name = document.getElementById("name").value;
	var price = document.getElementById("price").value;	
	var image = document.getElementById("prod_image").value;
	var description = document.getElementById("description").value;
	
	if (name == ""){
		alert("상품명을 입력해 주세요.");
		document.getElementById("name").focus();
		return false;
	}
	
	if (price == "") {
		alert("상품 가격을 입력해 주세요.");
		document.getElementById("price").focus();
		return false;
	}
	
	if (isNaN(price)) {
		alert("가격은 숫자를 입력해 주세요.");
		document.getElementById("price").focus();
		return false;
	}
	
	if (description == "") {
		alert("설명을 입력해 주세요.");
		document.getElementById("description").focus();
		return false;
	}
	
	return true;
}




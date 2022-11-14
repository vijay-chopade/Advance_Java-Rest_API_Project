<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lecture4</title>
<script type="text/javascript">
	var xmlhttp;
	//-----------------------------------------xxxxxxxxxxxxxxxxxxxxxxx
	function getData() {
		xmlhttp = new XMLHttpRequest();
		xmlhttp.onload = show;
		var rno = document.form1.rno.value;
		xmlhttp.open("get", "http://localhost:8081/student/" + rno);
		xmlhttp.send();
	}
	function show() {
		alert(xmlhttp.responseText);
		var obj = JSON.parse(xmlhttp.responseText);
		//document.form1.name.value = xmlhtml.responseText;
		document.form1.rno.value = obj.sid;
		document.form1.name.value = obj.sname;
		document.form1.marks.value = obj.smarks;
	}
	//-----------------------------------------xxxxxxxxxxxxxxxxxxxxxxx

	function deleteData() {
		xmlhttp = new XMLHttpRequest();
		xmlhttp.onload = show2;
		var rno = document.form1.rno.value;
		xmlhttp.open("delete", "http://localhost:8081/student/" + rno);
		xmlhttp.send();
	}
	function show2() {
		alert(xmlhttp.responseText);
	}
	//-----------------------------------------xxxxxxxxxxxxxxxxxxxxxxx

	function postData(button) {
		xmlhttp = new XMLHttpRequest();
		xmlhttp.onload = show3;
		var rno = document.form1.rno.value;
		var name = document.form1.name.value;
		var marks = document.form1.marks.value;
		var obj = {
			"sid" : rno,
			"sname" : name,
			"smarks" : marks
		};
		if(button.value == "Post"){
		xmlhttp.open("post", "http://localhost:8081/student");
		alert("Calling Post!")
		}
		else if(button.value == "Put"){
			xmlhttp.open("put", "http://localhost:8081/student");
			alert("Calling Put!")
		}else{
			alert("Calling Non!")
		}
		xmlhttp.setRequestHeader("Content-type", "application/json");
		xmlhttp.send(JSON.stringify(obj));
	}
	function show3() {
		alert(xmlhttp.responseText);
	}
	//-----------------------------------------xxxxxxxxxxxxxxxxxxxxxxx
	
	//-----------------------------------------xxxxxxxxxxxxxxxxxxxxxxx
</script>

</head>
<body>
	<form name="form1">

		<input type="text" name="rno" placeholder="roll no"/><br/> <br/> 
		<input type="text" name="name" placeholder="name"/><br/> <br/> 
		<input type="text" name="marks" placeholder="marks"/><br/> <br/> 
		<input type="button" onclick="postData(this)" value="Post"/> 
		<input type="button" onclick="getData()" value="Get"/> 
		<input type="button" onclick="postData(this)" value="Put"/> 
		<input type="button" onclick="deleteData()" value="Delete"/><br/> <br/> 

	</form>
</body>
</html>
const username = document.querySelector('#username');
const idCheck = document.querySelector('#id-check');
const signupValues = document.querySelectorAll('.signup-ip');

idCheck.onclick = () => {
	alert('아이디: ' + username.value);
	for(let i = 0; i < signupValues.length; i++){
		alert(signupValues[i].value);
	}
}

/*
signupValues[0].onblur = () => {
	const testText = document.querySelector('.test-text');
	testText.style.color = 'red';
	//testText.innerHTML = '<a href="#">테스트</a>';
	const aTag = document.createElement('a');
	const href = document.createAttribute('href');
	aTag.setAttributeNode(href);
	aTag.href = '#';
	
	const text = document.createTextNode('테스트');
	aTag.appendChild(text);
	testText.appendChild(aTag);
	
}
*/

const signupInputs = document.querySelectorAll('.signup-ip');
const idCheck = document.querySelector('#id-check');
const idCheckFlag = document.querySelector('#id-check-flag');
const signupForm = document.querySelector('form');
const submitFlag = document.querySelector('submit-flag');

idCheck.onclick = () => {
	if(signupInputs[0].value.length == 0){
		alert('아이디를 입력해 주세요.');
	}else{
		submitFlag.value = 1;
		signupForm.submit();
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

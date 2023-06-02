 window.onload = function(){
        /*各画面オブジェクト*/
        const btnSubmit = document.getElementById('btnSubmit');
        const name = document.getElementById('name');
        const pass = document.getElementById('pass');
        const inputMail = document.getElementById('inputMail');
        const checkKiyaku = document.getElementById('checkKiyaku');
        const reg = /^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}.[A-Za-z0-9]{1,}$/;
        
        
        btnSubmit.addEventListener('click', function(event) {
            let message = [];
            /*入力値チェック*/
            if(name.value ==""){
                message.push("IDかパスワードが間違っています。");
            }
            if(pass.value==""){
                message.push("IDかパスワードが間違っています。");
            }
            if(inputMail.value==""){
                message.push("メールアドレスが未入力です。");
            }else if(!reg.test(inputMail.value)){
                message.push("メールアドレスの形式が不正です。");
            }
            if(checkKiyaku.value){
                message.push("利用規約に同意してください。");
            }
            if(message.length > 0){
                alert(message);
                return;
            }
            alert('入力チェックOK');
        });
    };
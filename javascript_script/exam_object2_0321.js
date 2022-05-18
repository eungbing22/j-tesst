/**
 * 
 */

function info(){
	this.account=0;
	this.flag;	// 입금 or 출금
	this.date;	// 날짜
	this.amount;
}

var bank=[]
var account=[
	{'name':'kim', 'no':'12345', 'balance':0 },
	{'name':'lee', 'no':'67890', 'balance':0 }
]

var frm = document.bank;


// 입력 금액에 천단위 분리기호 넣기
frm.amount.onkeyup = function(){
	var temp = frm.amount.value.replaceAll(',','');
	temp = Number(temp).toLocaleString('ko');
	frm.amount.value = temp;
}


// date태그에 초기 날짜값 설정 오늘 날짜로
frm.nal.valueAsDate = new Date();

// 예금주명 표시
frm.account.onblur = function(){
	info = checkAccount(frm.account.value);
	if(info){
		frm.accName.value = info.name;
	}else{
		alert('계좌번호를 확인하세요.');
	}
}

// 신규 계좌 추가 logic
frm.btnAddAccount.onclick = function(){
	var win = window.open(
		'exam_object2_addAccount_ex.html',
		'win',
		'width=320, height=220'
	)		
}

// 전체 계좌 정보 출력
frm.btnPrintAccount.onclick = function(){
	var r = document.getElementById('result');
	var str = "<div class='title'>"
			+ "	<span class='no'>계좌번호</span>"
			+ "	<span class='name'>예금주</span>"
			+ "	<span class='balance'>잔액</span>"
			+ "</div>";
			
	for(x of account){
		str += "<div class='item'>"
			+ "		<span class='no'>" 		+ x.no + "</span>"
			+ "		<span class='name'>" 	+ x.name + "</span>"
			+ "		<span class='balance'>" + x.balance.toLocaleString('ko') + "</span>"
			+ "</div>";
	}	
	r.innerHTML = str;
}

frm.btnPrint.onclick = function(){
	var r = document.getElementById('result');
	// 날짜순으로 내림차순
	bank.sort(nalDesc);	

	acc = checkAccount(frm.account.value);
	var str = "<div>현 잔액 :"+acc.balance.toLocaleString('ko')+"</div>";
	
	// 입금 정보를 출력할 타이틀
		str += "<div class = 'title'>"
			+ "		<span class='nal'>거래일자</span>"
			+ "		<span class='dep'>입금</span>"
			+ "		<span class='wit'>출금</span>"
			+ "</div>";
			
	for(x of bank){
		if(x.account != frm.account.value) continue; 
				
		str += "<div class='item'>"
			+ "		<span class='nal'>" + x.date + "</span>";
			
		if(x.flag=='입금'){
			str += "<span class='dep'>" + x.amount.toLocaleString('ko') + "</span>"		
				+ "<span class='wit'></span>"		//출금일때는 아무것도 찍지 말기
		}else{
			str	+= "<span class='dep'></span>"		//입금일때는 아무것도 찍지 말기
				+ "<span class='wit'>" + x.amount.toLocaleString('ko') + "</span>"
		}
		str	+= "</div>";
	}		
	r.innerHTML = str;
}

// 날짜(date)를 내림차순으로 정렬
function nalDesc(x,y){
	if(y.date > x.date) return 1; 
	else return -1;
}

// 저장 버튼 클릭
frm.btnSave.onclick = function(){
	var no = frm.account.value;
	var acc = checkAccount(no);
	if(acc == null){
		alert('해당 계좌가 없습니다.');
		return;
	}
	
	var info = new Info();
	info.account = frm.account.value;
	
	// 사용자가 지정한 날짜에 현재 시간을 추가
	var now = new Date();
	var y = frm.nal.value.substr(0,4);
	var m = frm.nal.value.substr(5,2);
	var d = frm.nal.value.substr(8,2);
	
	var tempDate = new Date()
	tempDate.setFullYear(y);
	tempDate.setMonth(m-1);
	tempDate.setDate(d);
	
	info.date = tempDate.toLocaleString('ko');
	
	// 천단위 분리기호를 숫자로 변환
	tempAmt = frm.amount.value.replaceAll(',' , '');
	info.amount = Number(tempAmt);
	
	if(frm.trans[0].checked){
		info.flag = frm.trans[0].value;
		deposit(info);
	}else{
		info.flag = frm.trans[1].value;
		withdraw(info);
	}

	info.date = new Date().toLocaleString('ko');
	info.amount = Number(frm.amount.value);
	
	if(frm.trans[0].checked){ 
		info.flag = frm.trans[0].value;	 	
		deposit(info);			
	}else{
		info.flag = frm.trans[1].value;	
		withdraw(info); 
	}
	
	frm.btnPrint.click();
} 

// 출금처리(잔고 감소)
function withdraw(info){
	rInfo = checkAccount(info.account);
	if(rInfo){
		// 계좌가 있다면 잔액체크
		if(rInfo.balance>=info.amount){
			rInfo.balance-=Number(info.amount);
			bank.push(info);
			//console.log(rInfo.balance);
		}else{
			alert('잔액이 부족합니다.');
		}
	}else{
		alert('계좌 번호를 확인해주세요.');		
	}
}

// 입금처리(잔고 증가)
function deposit(info){
	for(x of account){
		if(x.no == info.account){
			x.balance += Number(info.amount);
			console.log(x.balance);
		}
	}	
	bank.push(info); 					
}

// 계좌조회 
// 3가지 입금, 출금, 통장개설에 공통되는 내용
// 계좌번호를 매개변수 no로 전달받아
// account[](account 배열)에서 찾아서, 있으면 해당 account를 반환

function checkAccount(no){
	var returnInfo;
	for(x of account){
		if(x.no == no){
			returnInfo = x;
			break;
		}
	}
	return returnInfo;
}
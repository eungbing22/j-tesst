/**
 * 성적 정보 처리 
	date : 2022.03.22
 */
var frm = document.frm;
var info = document.getElementById('info')

// 기본 학생 정보
var students = [
	{ 'no' : 1, 'name' : 'hong', 'grade' : 1 },
	{ 'no' : 2, 'name' : 'kim',  'grade' : 1 },	
	{ 'no' : 3, 'name' : 'lee',  'grade' : 2 },
	{ 'no' : 4, 'name' : 'park', 'grade' : 3 },	
	{ 'no' : 5, 'name' : 'nam',  'grade' : 4 }
]

var subjects = ['국어','영어','수학','전산','세계사','역사']

// 기본 성적 정보
var scores = [
	{'serial': 1, 'no': 1, 'subject':'수학', 'score' : 100},
	{'serial': 2, 'no': 2, 'subject':'국어', 'score' : 70},
	{'serial': 3, 'no': 3, 'subject':'국어', 'score' : 80},
	{'serial': 4, 'no': 4, 'subject':'국어', 'score' : 60},
	{'serial': 5, 'no': 5, 'subject':'국어', 'score' : 100}
];
// 성적 정보 저장
var scores_serial = scores.length;
var stuSerial;

// 과목 설정
subjects.sort();

for(x of subjects){
	frm.subject.append(new Option(x,x))	
}

// 검색 버튼이 클릭되면 
frm.btnSearch.onclick = function(){
	var message = '학번을 확인해 주세요.';
	frm.name.value = '';
	frm.grade.value = '';
	frm.subject.value = '';
	frm.score.value = '';
	stuSerial = 0;
	
	for(x of students){
		if(x.no == frm.no.value){
			frm.name.value = x.name;
			frm.grade.value = x.grade;
			message = '성적을 입력해 주세요.';
			break;
		}
	}
	info.innerHTML = message;	
}
// 저장 버튼이 클릭되면
frm.btnSave.onclick = function(){
	scores_serial++;
	var s = {
		"serial"  : scores_serial,
		"no"      : frm.no.value,
		"subject" : frm.subject.value,
		"score"   : Number(frm.score.value) 
	}
	scores.push(s);
	
	// info에 저장된 총건수 출력하기
	info.innerHTML = '성적이 저장되었습니다.'
				   + '<b>총건수 : '
				   + scores.length + '</b>'
	
	frm.no.value = '';
	frm.name.value = '';
	frm.grade.value = '';
	frm.subject.value = '';
	frm.score.value = '';
	frm.no.focus();
	stuSerial = 0;
}

// 출력 버튼이 클릭되면
frm.btnPrint.onclick = function(){
	var str = '';
	var r = document.getElementById('result');
	for(x of scores){
		for(s of students){
			if(x.no==s.no){
				str +="<div class='items' onclick='go(" + x.serial  +")'      >"
					+ "	    	<span class='serial'>"  + x.serial  +"</span>"
					+ "	    	<span class='no'>"      + x.no      +"</span>"
					+ "	    	<span class='name'>"    + s.name    +"</span>"
					+ "	    	<span class='grade'>"   + s.grade   +"</span>"
					+ "	    	<span class='subject'>" + x.subject +"</span>"
					+ "	    	<span class='score'>"   + x.score   +"</span>"
					+"</div>";
			}
		}
	}
	r.innerHTML = str;
}

// 수정 버튼이 클릭되면
frm.btnRetouch.onclick = function(){
	for(s of scores){
		if(s.serial == stuSerial){
			s.subject == frm.subject.value;
			s.score == Number(frm.score.value);
			frm.btnPrint.click();
			stuSerial = 0;
			break;	
		}
	}
}

// 삭제 버튼이 클릭되면
frm.btnDelete.onclick = function(){
	for(s in scores){
		if(scores[s].serial == stuSerial){
			scores.splice(s,1);
			frm.btnPrint.click();
			info.innerHTML = '데이터가 삭제되었습니다.';
			frm.no.value = '';
			frm.name.value = '';
			frm.grade.value = '';
			frm.subject.value = '';
			frm.score.value = '';
			frm.no.focus();
			stuSerial = 0;
		}
	}
}

function go(serial){
	for(s of scores){
		if(s.serial == serial){
			frm.no.value = s.no;
			frm.subject.value = s.subject;
			frm.score.value = s.score;
			stuSerial = s.serial; 
			
			//학번이 일치헸을때
			for(x of students){
				if(x.no == s.no){
					frm.name.value = x.name;
					frm.grade.value = x.grade;
					break;
				}
			}
		}
	}
}
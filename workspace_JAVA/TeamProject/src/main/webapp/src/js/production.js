// 생산 관리 페이지 JavaScript

// 전역 변수
let lotData = [];
let equipmentData = [];
let workerData = [];
let processData = {};

// 페이지 로드 시 초기화
document.addEventListener('DOMContentLoaded', function() {
    // 서버사이드 렌더링으로 전환: 더미 데이터 로딩 제거
    initializePage();
    setupEventListeners();
});

// 페이지 초기화
function initializePage() {
    console.log('생산 관리 페이지 초기화 중...');
    
    // 현재 시간 설정
    const now = new Date();
    const startDateInput = document.getElementById('startDate');
    if (startDateInput) {
        startDateInput.value = now.toISOString().slice(0, 16);
    }
    
    // 서버에서 JSTL로 옵션 렌더링하므로 JS 로딩 불필요
}

// 이벤트 리스너 설정
function setupEventListeners() {
    // 모달 닫기 버튼
    const closeBtn = document.querySelector('.close');
    if (closeBtn) {
        closeBtn.addEventListener('click', closeAddLotModal);
    }
    
    // 모달 외부 클릭 시 닫기
    window.addEventListener('click', function(event) {
        const modal = document.getElementById('addLotModal');
        if (event.target === modal) {
            closeAddLotModal();
        }
    });
    
    // LOT 추가 폼 제출
    const addLotForm = document.getElementById('addLotForm');
    if (addLotForm) {
        addLotForm.addEventListener('submit', handleAddLot);
    }
    
    // 공정 카드 클릭 이벤트
    const processCards = document.querySelectorAll('.process-card');
    processCards.forEach(card => {
        card.addEventListener('click', function() {
            const processType = this.dataset.process;
            showProcessDetail(processType);
        });
    });
}

// LOT 데이터 로드
// 서버사이드 렌더링을 사용하므로 더미 데이터 로딩 비활성화
function loadLotData() {}

// 설비 데이터 로드
function loadEquipmentData() {}

// 작업자 데이터 로드
function loadWorkerData() {}

// 공정 데이터 로드
function loadProcessData() {}

// LOT 테이블 렌더링
function renderLotTable() {
    const tbody = document.getElementById('lotTableBody');
    if (!tbody) return;
    
    tbody.innerHTML = '';
    
    lotData.forEach(lot => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${lot.id}</td>
            <td>${lot.productName}</td>
            <td>${lot.quantity}개</td>
            <td>${lot.currentProcess}</td>
            <td>
                <div class="progress-bar">
                    <div class="progress-fill" style="width: ${lot.progress}%"></div>
                </div>
                <span>${lot.progress}%</span>
            </td>
            <td>${lot.startTime}</td>
            <td>${lot.worker}</td>
            <td>
                <span class="status-badge status-${getStatusClass(lot.status)}">
                    ${getStatusText(lot.status)}
                </span>
            </td>
            <td>
                <button class="btn-secondary" onclick="editLot('${lot.id}')">수정</button>
                <button class="btn-secondary" onclick="deleteLot('${lot.id}')">삭제</button>
            </td>
        `;
        tbody.appendChild(row);
    });
}

// 설비 테이블 렌더링
function renderEquipmentTable() {
    const tbody = document.getElementById('equipmentTableBody');
    if (!tbody) return;
    
    tbody.innerHTML = '';
    
    equipmentData.forEach(equipment => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${equipment.id}</td>
            <td>${equipment.name}</td>
            <td>
                <span class="operating-status status-${equipment.status.toLowerCase()}">
                    ${getEquipmentStatusText(equipment.status)}
                </span>
            </td>
            <td>${equipment.oee}%</td>
            <td>${equipment.lastInspection}</td>
            <td>
                <button class="btn-secondary" onclick="viewEquipmentDetail('${equipment.id}')">상세</button>
                <button class="btn-secondary" onclick="scheduleMaintenance('${equipment.id}')">점검</button>
            </td>
        `;
        tbody.appendChild(row);
    });
}

// 작업자 테이블 렌더링
function renderWorkerTable() {
    const tbody = document.getElementById('workerTableBody');
    if (!tbody) return;
    
    tbody.innerHTML = '';
    
    workerData.forEach(worker => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${worker.id}</td>
            <td>${worker.name}</td>
            <td>${worker.currentProcess}</td>
            <td>
                <span class="skill-level skill-${worker.skillLevel.toLowerCase()}">
                    ${getSkillLevelText(worker.skillLevel)}
                </span>
            </td>
            <td>
                <span class="work-shift shift-${worker.workShift.toLowerCase()}">
                    ${getWorkShiftText(worker.workShift)}
                </span>
            </td>
            <td>${worker.todayProduction}개</td>
            <td>
                <button class="btn-secondary" onclick="viewWorkerDetail('${worker.id}')">상세</button>
                <button class="btn-secondary" onclick="reassignProcess('${worker.id}')">재배정</button>
            </td>
        `;
        tbody.appendChild(row);
    });
}

// 공정 카드 업데이트
function updateProcessCards() {
    Object.keys(processData).forEach(processType => {
        const card = document.querySelector(`[data-process="${processType}"]`);
        if (card) {
            const data = processData[processType];
            
            // LOT 수 업데이트
            const lotCountSpan = card.querySelector('.lot-count');
            if (lotCountSpan) lotCountSpan.textContent = data.lotCount;
            
            // 진행률 업데이트
            const progressSpan = card.querySelector('.progress-rate');
            if (progressSpan) progressSpan.textContent = data.progressRate + '%';
            
            // 예상 완료 시간 업데이트
            const etaSpan = card.querySelector('.eta');
            if (etaSpan) etaSpan.textContent = data.eta;
            
            // 상태 업데이트
            const statusDiv = card.querySelector('.process-status');
            if (statusDiv) {
                statusDiv.className = `process-status ${data.status}`;
                statusDiv.textContent = getProcessStatusText(data.status);
            }
        }
    });
}

// 상태 클래스 반환
function getStatusClass(status) {
    const statusMap = {
        'IN_PROGRESS': 'in-progress',
        'COMPLETED': 'completed',
        'QUALITY_CHECK': 'quality-check',
        'DELAYED': 'delayed'
    };
    return statusMap[status] || 'in-progress';
}

// 상태 텍스트 반환
function getStatusText(status) {
    const statusMap = {
        'IN_PROGRESS': '진행중',
        'COMPLETED': '완료',
        'QUALITY_CHECK': '품질검사',
        'DELAYED': '지연'
    };
    return statusMap[status] || '진행중';
}

// 설비 상태 텍스트 반환
function getEquipmentStatusText(status) {
    const statusMap = {
        'OPERATING': '가동중',
        'WAITING': '대기',
        'BREAKDOWN': '고장',
        'MAINTENANCE': '점검중'
    };
    return statusMap[status] || '대기';
}

// 숙련도 텍스트 반환
function getSkillLevelText(level) {
    const levelMap = {
        'BEGINNER': '초급',
        'INTERMEDIATE': '중급',
        'EXPERT': '고급'
    };
    return levelMap[level] || '초급';
}

// 근무조 텍스트 반환
function getWorkShiftText(shift) {
    const shiftMap = {
        'DAY': '주간',
        'NIGHT': '야간'
    };
    return shiftMap[shift] || '주간';
}

// 공정 상태 텍스트 반환
function getProcessStatusText(status) {
    const statusMap = {
        'normal': '정상',
        'delayed': '지연',
        'waiting': '대기',
        'warning': '주의'
    };
    return statusMap[status] || '정상';
}

// LOT 검색
function searchLots() {
    const searchTerm = document.getElementById('lotSearch').value.toLowerCase();
    const statusFilter = document.getElementById('statusFilter').value;
    
    const filteredLots = lotData.filter(lot => {
        const matchesSearch = lot.id.toLowerCase().includes(searchTerm) || 
                             lot.productName.toLowerCase().includes(searchTerm);
        const matchesStatus = !statusFilter || lot.status === statusFilter;
        
        return matchesSearch && matchesStatus;
    });
    
    renderFilteredLotTable(filteredLots);
}

// 필터링된 LOT 테이블 렌더링
function renderFilteredLotTable(filteredLots) {
    const tbody = document.getElementById('lotTableBody');
    if (!tbody) return;
    
    tbody.innerHTML = '';
    
    if (filteredLots.length === 0) {
        const row = document.createElement('tr');
        row.innerHTML = '<td colspan="9" style="text-align: center; padding: 20px;">검색 결과가 없습니다.</td>';
        tbody.appendChild(row);
        return;
    }
    
    filteredLots.forEach(lot => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${lot.id}</td>
            <td>${lot.productName}</td>
            <td>${lot.quantity}개</td>
            <td>${lot.currentProcess}</td>
            <td>
                <div class="progress-bar">
                    <div class="progress-fill" style="width: ${lot.progress}%"></div>
                </div>
                <span>${lot.progress}%</span>
            </td>
            <td>${lot.startTime}</td>
            <td>${lot.worker}</td>
            <td>
                <span class="status-badge status-${getStatusClass(lot.status)}">
                    ${getStatusText(lot.status)}
                </span>
            </td>
            <td>
                <button class="btn-secondary" onclick="editLot('${lot.id}')">수정</button>
                <button class="btn-secondary" onclick="deleteLot('${lot.id}')">삭제</button>
            </td>
        `;
        tbody.appendChild(row);
    });
}

// LOT 추가 모달 열기
function openAddLotModal() {
    const modal = document.getElementById('addLotModal');
    if (modal) {
        modal.style.display = 'block';
    }
}

// LOT 추가 모달 닫기
function closeAddLotModal() {
    const modal = document.getElementById('addLotModal');
    if (modal) {
        modal.style.display = 'none';
    }
}

// 작업자 옵션 로드
function loadWorkerOptions() {
    const workerSelect = document.getElementById('workerSelect');
    if (!workerSelect) return;
    
    workerSelect.innerHTML = '<option value="">작업자를 선택하세요</option>';
    
    workerData.forEach(worker => {
        const option = document.createElement('option');
        option.value = worker.id;
        option.textContent = `${worker.name} (${worker.currentProcess})`;
        workerSelect.appendChild(option);
    });
}

// LOT 추가 처리
function handleAddLot(event) {
    event.preventDefault();
    
    const formData = new FormData(event.target);
    const lotData = {
        productId: formData.get('productId'),
        quantity: formData.get('quantity'),
        workerId: formData.get('workerId'),
        startDate: formData.get('startDate')
    };
    
    // 실제 구현에서는 서버로 데이터를 전송합니다
    console.log('새 LOT 데이터:', lotData);
    
    // 성공 메시지 표시
    alert('LOT이 성공적으로 생성되었습니다.');
    
    // 모달 닫기
    closeAddLotModal();
    
    // 폼 초기화
    event.target.reset();
    
    // LOT 데이터 새로고침
    loadLotData();
}

// LOT 수정
function editLot(lotId) {
    console.log('LOT 수정:', lotId);
    // 실제 구현에서는 수정 모달을 열거나 페이지로 이동합니다
    alert(`${lotId} LOT 수정 기능은 개발 중입니다.`);
}

// LOT 삭제
function deleteLot(lotId) {
    if (confirm(`${lotId} LOT을 정말 삭제하시겠습니까?`)) {
        console.log('LOT 삭제:', lotId);
        // 실제 구현에서는 서버로 삭제 요청을 보냅니다
        
        // 로컬 데이터에서 제거
        lotData = lotData.filter(lot => lot.id !== lotId);
        renderLotTable();
        
        alert(`${lotId} LOT이 삭제되었습니다.`);
    }
}

// 설비 상세 보기
function viewEquipmentDetail(equipmentId) {
    console.log('설비 상세:', equipmentId);
    alert(`${equipmentId} 설비 상세 정보는 개발 중입니다.`);
}

// 점검 일정 잡기
function scheduleMaintenance(equipmentId) {
    console.log('점검 일정:', equipmentId);
    alert(`${equipmentId} 점검 일정 잡기 기능은 개발 중입니다.`);
}

// 작업자 상세 보기
function viewWorkerDetail(workerId) {
    console.log('작업자 상세:', workerId);
    alert(`${workerId} 작업자 상세 정보는 개발 중입니다.`);
}

// 공정 재배정
function reassignProcess(workerId) {
    console.log('공정 재배정:', workerId);
    alert(`${workerId} 공정 재배정 기능은 개발 중입니다.`);
}

// 공정 상세 보기
function showProcessDetail(processType) {
    console.log('공정 상세:', processType);
    alert(`${processType} 공정 상세 정보는 개발 중입니다.`);
}

// 데이터 내보내기
function exportLotData() {
    console.log('LOT 데이터 내보내기');
    alert('LOT 데이터 내보내기 기능은 개발 중입니다.');
}

// 실시간 업데이트 (5초마다)
// 서버 렌더링을 사용하므로 주기적 더미 업데이트 비활성화

// 공정 진행률 업데이트
function updateProcessProgress() {
    // 실제 구현에서는 서버에서 실시간 데이터를 가져와 업데이트합니다
    Object.keys(processData).forEach(processType => {
        if (processData[processType].lotCount > 0) {
            // 진행률을 약간 증가시킵니다 (시연용)
            const currentProgress = processData[processType].progressRate;
            if (currentProgress < 100) {
                processData[processType].progressRate = Math.min(100, currentProgress + Math.random() * 5);
            }
        }
    });
    
    updateProcessCards();
}

package com.spring.board.vo;

public class PageVo{
	
	private String[] codeId; 
	
    private int pageNo; // 현재 페이지 번호
    private int perPageNum; // 페이지당 보여줄 게시글의 개수
    
    private int totalCount; // 게시판 전체 데이터 개수
    private int displayPageNum = 5; // 게시판 화면에서 한번에 보여질 페이지 번호의 개수(하단 페이지 번호)
    
    private int startPage; // 화면의 시작 번호
    private int endPage;  // 화면의 끝 번호
    private int tempEndPage;
    private boolean prev; // 페이징 이전 버튼 활성화 여부
    private boolean next; // 페이징 다음 버튼 활성화 여부
    
    public int getPageStart() {
    	return (this.pageNo -1) * perPageNum;
    }
    
    public PageVo() {
    	this.pageNo = 1;
    	this.perPageNum = 10;
    }
    
    public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		if(pageNo <= 0) {
			this.pageNo = 1;
		}else {
			this.pageNo = pageNo;
		}
	}
    
	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		   int cnt = this.perPageNum;
	        
	        if(perPageNum != cnt) {
	            this.perPageNum = cnt;    
	        } else {
	            this.perPageNum = perPageNum;
	        }
	}

	public int getTotalCount() {
        return totalCount;
    }
 
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        
        pagingData();
    }
    
    private void pagingData() {
    	// endPage = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 개수) * 화면에 보여질 페이지 번호의 개수
        endPage = (int)(Math.ceil(getPageNo()/(double)displayPageNum) * displayPageNum);
        // startPage = (끝 페이지 번호 - 화면에 보여질 페이지 번호의 개수) + 1
        startPage = (endPage - displayPageNum) + 1;
        
        // 마지막 페이지 번호 = 총 게시글 수 / 한 페이지당 보여줄 게시글의개수
        tempEndPage = (int)(Math.ceil(totalCount/(double) getPerPageNum()));    
        if(endPage > tempEndPage) {
            endPage = tempEndPage;
        }
        // 이전 버튼 생성 여부 = 시작 페이지 번호가 1과 같으면 false, 아니면 true
        prev = startPage == 1 ? false : true;    
        // 다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지당 보여줄 게시글의 개수가 총 게시글의 수보다
        // 크거나 같으면 false, 아니면 true
        next = endPage * getPerPageNum() >= totalCount ? false : true;
    
    }
 
    public int getDisplayPageNum() {
        return displayPageNum;
    }
 
    public void setDisplayPageNum(int displayPageNum) {
        this.displayPageNum = displayPageNum;
    }
 
    public int getStartPage() {
        return startPage;
    }
 
    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }
 
    public int getEndPage() {
        return endPage;
    }
 
    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
 
    public boolean isPrev() {
        return prev;
    }
 
    public void setPrev(boolean prev) {
        this.prev = prev;
    }
 
    public boolean isNext() {
        return next;
    }
 
    public void setNext(boolean next) {
        this.next = next;
    }

	public int getTempEndPage() {
		return tempEndPage;
	}

	public void setTempEndPage(int tempEndPage) {
		this.tempEndPage = tempEndPage;
	}

	public String[] getCodeId() {
		return codeId;
	}

	public void setCodeId(String[] codeId) {
		this.codeId = codeId;
	}
    
}

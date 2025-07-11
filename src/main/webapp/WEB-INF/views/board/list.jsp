<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ include file="../includes/header.jsp" %> <!-- 위쪽에 반복되는 메뉴들... -->


            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           MBCBoard List Page
                           <button id='regBtn' type="button" class="btn btn-xs pull-right">게시글등록</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>#번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                                
                                <!-- model에서 전달된 리스트를 출력 한다. -->
                                
                                <c:forEach items="${list}" var="board"> 
                                <!-- 컨트롤러에서 전달된 리스트+제네릭 처리용 -->
                                <!-- 서비스에서 만들어져 나옴 List<BoardVO>  -->
                                <!-- 컨트롤러에서 model.addAttribute("list", service.getList()); -->
                                	<tr>
                                		<td><c:out value="${board.bno}" /></td>

							<td>
								<a href='/board/get?bno=<c:out value="${board.bno }"/>'>
								<c:out value="${board.title}" />
							</a>
							</td>
							
							<td><c:out value="${board.writer}" /></td>
	                                	<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}" /></td>
	                                	<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}" /></td>
                                	</tr>
                                
                                </c:forEach>
                                
                             </table>   
                             
                             
                            <!-- Modal 추가 p248 경고창 대신 모달을 사용해본다. -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">MBC Board</h4>
                                        </div>
                                        <div class="modal-body">
                                            처리가 완료 되었습니다.
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                                            <button type="button" class="btn btn-primary">저장(적용)</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal  모달 종료 -->
                             
                             
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
    
    <%@ include file="../includes/footer.jsp" %>
    
    <script type="text/javascript"> /* CURD 처리결과 메세지를 출력하는 코드 */
    
    $(document).ready(
    	function(){
    		var result = '<c:out value="${result}"/>';
	
    		checkModal(result);		
    		
    		function checkModal(result){
    						
	    		if(result === ''){
	    			return;
	    			// 입력값이 없으면 돌아감
	    		}	
    		
	    		if(parseInt(result)>0){
	    			// 게시물 등록번호가 넘어오면!!!
	    			$(".modal-body").html("게시글 " + parseInt(result) + "번이 등록 되었습니다.");
	    		}
	    		
	    		$("#myModal").modal("show"); // 모달창을 화면에 띄어라!!!
	    		
    		}//modal종료
    		
    		$("#regBtn").on("click", function(){
    			// regBtn 버튼을 클릭했을때 어떤 실행?
    					
    				self.location = "/board/register";
    				// 위치를 이동해라 "http://192.168.111.104:80/board/register 로
    		});
    		
    	
    	}	/* 백엔드에서 처리 결과를 받는 변수를 연동 */
	    	/* 등록시 : rttr.addFlashAttribute("result",board.getBno());   */
	    	/* 수정시 : rttr.addFlashAttribute("result","success"); */
	    	/* 삭제시 : rttr.addFlashAttribute("result","success"); */
    );
    

	</script>
    
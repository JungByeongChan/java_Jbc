import React from 'react';
import './css/Body.css';



function Body(){
	
	let [page, setPage] = React.useState(1);
	
	function pageNext(){
		setPage(page + 1)
	}
	
	function pagePrev(){
		setPage(page - 1)
		
	}


	return (
		<div className='body'>
			<button onClick={pagePrev}>&lt;</button>
			<span>{page}/13</span>
			<button onClick={pageNext}>&gt;</button>

		</div>
	);
}


export default Body;

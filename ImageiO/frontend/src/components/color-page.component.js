import React, { Component } from "react";
import PixelGrid from "react-pixel-grid";


export default class ColorPage extends Component {
    constructor(props){
        super(props);
        this.state = {
            data: undefined,
        }
    }
    setData(data){
        this.setState({data: data});
    }
    render() {
       return(
       <div>
            <PixelGrid
                data={Array(64).fill(0).map(Math.random)}
                options={{
                size: 10,
                padding: 2,
                background: [0, 0.5, 1],
                }}
            />
       </div>
       );
    }
}
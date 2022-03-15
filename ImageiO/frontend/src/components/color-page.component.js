import React, { Component } from "react";
import PixelGrid from "react-pixel-grid";


const ColorPage = (props) => {
    const {data} = props;
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

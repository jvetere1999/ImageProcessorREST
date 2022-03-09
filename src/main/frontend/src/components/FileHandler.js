import React from 'react';

import { FileDrop } from 'react-file-drop';
import '../style/FileHandler.css'

const FileHandler = ()  => {
    const styles = { border: '1px solid black', width: 600, color: 'black', padding:20 };
    return (
        <div>
            <h1>Drop File Here</h1>
            <div style={styles}>
                <FileDrop
                    onDrop = {(files,  event) => console.log('onDrop', files, event)} >
                        Drop files, (PNG, JPEG);
                    </FileDrop>
            </div>
        </div>
    );
};
export default FileHandler;
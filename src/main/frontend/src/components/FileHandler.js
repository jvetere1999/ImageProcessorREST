import { computeHeadingLevel } from '@testing-library/react';
import React, { Component } from 'react';

import { FileDrop } from 'react-file-drop';
import '../style/FileHandler.css'
import UploadFiles from './upload-files.component';

class FileHandler extends Component {
    
    render () {
        const styles = { border: '1px solid black', width: 600, color: 'black', padding:20 };
        return(
        <div>
            <h1>Drop File Here</h1>
            <div style={styles}>
                <FileDrop
                    onDrop = {(files,  event) => this.selectedFiles(event.target.file = files)} >
                        Drop files, (PNG, JPEG);
                    </FileDrop>
            </div>
        </div>);
    }
}
export default FileHandler;
import { FormGroup, FormControl, FormBuilder, Validators, FormArray } from '@angular/forms';

export class FormGroupMaker {
    static makeFormGroup(fb : FormBuilder) {
        return fb.group(
            this.makeDesc(fb)
        )
    }
    
    static makeDesc(fb : FormBuilder) {
        return {
            filter: ['']
       }
    }
}
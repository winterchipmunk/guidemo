import { FormGroup, FormControl, FormBuilder, Validators, FormArray } from '@angular/forms';

import { forbiddenValueValidator, duplicatedValueValidator } from '../shared/validators.directive'

export class FormGroupMaker {
    static makeFormGroup(fb : FormBuilder) {
        return fb.group(
            this.makeDesc(fb),
            {validators: duplicatedValueValidator("name", "desc")}
        )
    }
    
    static makeDesc(fb : FormBuilder) {
        return {
            id: [''],
            name: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(10), forbiddenValueValidator(/bad/i)]],
            type : ['', [Validators.required]],
            ip : ['', [Validators.required]],
            desc: [''],
            createdDate : ['']
       }
    }
}
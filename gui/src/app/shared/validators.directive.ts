import { ValidatorFn, AbstractControl, FormGroup, ValidationErrors } from '@angular/forms';

/** A field value can't match the given regular expression */
export function forbiddenValueValidator(valueRe: RegExp): ValidatorFn {
    return (control: AbstractControl): {[key: string]: any} | null => {
      const forbidden = valueRe.test(control.value);
      return forbidden ? {'forbiddenValue': {value: control.value}} : null;
    };
}

/** field one's value can't match field two's  */
export function duplicatedValueValidator(field1 : string, field2 : string): ValidatorFn {
    return (control: FormGroup): ValidationErrors | null => {
        const control1 = control.get(field1);
        const control2 = control.get(field2);
      
        return control1 && control2 && control1.value === control2.value ? { 'duplicatedValue': {value: control1.value} } : null;
    };
}
